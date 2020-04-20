package com.jbt.microserviceapplication.service;

import com.jbt.microserviceapplication.entity.Email;
import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.handler.PersonNotFoundException;
import com.jbt.microserviceapplication.model.PersonDto;
import com.jbt.microserviceapplication.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class PersonServiceImpl<P extends Person> implements PersonService {

  private PersonRepository personRepository;

  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person savePerson(PersonDto personDto) {
    return personRepository.save(mapPerson(personDto));
  }

  @Override
  public Optional<Person> getPerson(Long id) {
    return personRepository.findById(id);
  }

  @Override
  public Person updatePerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  public void deletePersonByNameAndAge(PersonDto personDto) {
    personRepository.deletePersonByNameAndDob(personDto.getName(), personDto.getDob());
  }

  @Override
  public void deletePersonById(Long id) {
    if (personRepository.existsById(id)) {
      personRepository.deleteById(id);
    } else {
      throw new PersonNotFoundException(id);
    }
  }

  @Override
  public List<Person> getAllPersons(int pageNumber, int pageSize) {
    return personRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }

  @Override
  public List<PersonDto> getAllPersons() {
    List<Person> person = personRepository.findAll();
    return person.stream().map(PersonDto::new).collect(Collectors.toList());
  }

  private Person mapPerson(PersonDto personDto) {
    return Person.builder()
        .name(personDto.getName())
        .address(personDto.getAddress())
        .qualification(personDto.getQualification())
        .dob(personDto.getDob())
        .gender(personDto.getGender())
        .height(personDto.getHeight())
        .email(getEmails(personDto))
        .build();
  }

  private List<Email> getEmails(PersonDto personDto) {
    if (CollectionUtils.isEmpty(personDto.getEmail())) {
      return new ArrayList<>();
    }
    return personDto.getEmail().stream().map(Email::new).collect(Collectors.toList());
  }
}
