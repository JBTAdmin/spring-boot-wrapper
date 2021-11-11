package com.jbt.service;

import com.jbt.repository.EmailRepository;
import com.jbt.manager.mysql.entity.Person;
import com.jbt.manager.oracle.entity.Email;
import com.jbt.model.PersonDto;
import com.jbt.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class DbServiceImpl implements DbService {

  private PersonRepository personRepository;
  private EmailRepository emailRepository;

  public DbServiceImpl(PersonRepository personRepository, EmailRepository emailRepository) {
    this.personRepository = personRepository;
    this.emailRepository = emailRepository;
  }

  @Override
  public Person createPerson(PersonDto personDto) {
    return personRepository.save(mapPerson(personDto));
  }

  @Override
  public Optional<Person> getPerson(Long id) {
    return personRepository.findById(id);
  }

  @Override
  public Person editPerson(PersonDto personDto) {
    return personRepository.save(mapPerson(personDto));
  }

  @Override
  public void deletePersonById(Long id) {
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

  private Person mapPerson(PersonDto personDto) {
    return Person.builder()
        .name(personDto.getName())
        .address(personDto.getAddress())
        .qualification(personDto.getQualification())
        .dob(personDto.getDob())
        .gender(personDto.getGender())
        .build();
  }
}
