package com.jbt.service;

import com.jbt.config.CustomerMapper;
import com.jbt.config.PersonMapper;
import com.jbt.manager.mysql.entity.Person;
import com.jbt.manager.mysql.repository.PersonRepository;
import com.jbt.manager.oracle.entity.Customer;
import com.jbt.manager.oracle.entity.Email;
import com.jbt.manager.oracle.repository.CustomerRepository;
import com.jbt.manager.oracle.repository.EmailRepository;
import com.jbt.model.CustomerDto;
import com.jbt.model.PersonDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class DbServiceImpl implements DbService {

  private PersonRepository personRepository;
  private CustomerRepository customerRepository;
  private EmailRepository emailRepository;
  //  private MapperFacade mapperFacade;
  private CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
  private PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);


  public DbServiceImpl(PersonRepository personRepository, CustomerRepository customerRepository, EmailRepository emailRepository) {
    this.personRepository = personRepository;
    this.customerRepository = customerRepository;
    this.emailRepository = emailRepository;
    INSTANCE = Mappers.getMapper(CustomerMapper.class);
  }

  @Override
  public PersonDto createPerson(PersonDto personDto) {
    Person person = personMapper.PersonDtoToPerson(personDto);
    return personMapper.personToPersonDto(personRepository.save(person));
  }

  @Override
  public Optional<Person> getPerson(UUID id) {
    return personRepository.findById(id);
  }

  @Override
  public Person editPerson(PersonDto personDto) {
    return personRepository.save(mapPerson(personDto));
  }

  @Override
  public void deletePersonById(UUID id) {
    personRepository.deleteById(id);
  }

  @Override
  public List<Person> getAllPersons(int pageNumber, int pageSize) {
    return personRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }

  @Override
  public List<PersonDto> getAllPersons() {
    List<Person> person = personRepository.findAll();
    if (CollectionUtils.isEmpty(person)) {
      return null;
    }
    List<PersonDto> personDtos = new ArrayList<>();

    for (Person person1 : person) {
      List<Email> emails = emailRepository.findAllByPersonId(person1.getId());
      personDtos.add(new PersonDto(person1, emails));
    }

    return personDtos;
  }

  @Override
  public List<CustomerDto> getAllCustomer() {
    List<Customer> customers = customerRepository.findAll();

    List<CustomerDto> customerDtos = new ArrayList<>();

    for (Customer customer : customers) {
      customerDtos.add(CustomerDto.builder().name(customer.getName()).gender(customer.getGender()).build());
    }

    return customerDtos;

  }

  @Override
  public CustomerDto createCustomer(CustomerDto customerDto) {
    Customer customer = customerRepository.save(INSTANCE.customerDtoToCustomer(customerDto));
    return INSTANCE.customerToCustomerDto(customer);
//    return null;//mapperFacade.map(customer, CustomerDto.class);
  }

  @Override
  public CustomerDto getCustomer(UUID id) {
    Optional<Customer> customer = customerRepository.findById(id);
    if(customer.isPresent()){
      return null;//mapperFacade.map(customer.get(), CustomerDto.class);
    }
    return null;
  }

  private Person mapPerson(PersonDto personDto) {
    return Person.builder()
        .name(personDto.getPersonName())
        .address(personDto.getAddress())
        .qualification(personDto.getQualification())
        .dob(personDto.getDob())
        .gender(personDto.getGender())
        .build();
  }
}
