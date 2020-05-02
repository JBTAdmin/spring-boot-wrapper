package com.jbt.springbootredis.service;

import com.jbt.springbootredis.model.Person;
import com.jbt.springbootredis.repository.PersonRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  PersonRepository personRepository;

  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person createPerson(Person person) {
    personRepository.save(person);
    return null;
  }

  @Override
  public Person getPerson(Long id) {
    return personRepository.findById(id);
  }

  @Override
  public List<Person> getAllPersons() {
    return personRepository.findAll().values().stream().collect(Collectors.toList());
  }
}
