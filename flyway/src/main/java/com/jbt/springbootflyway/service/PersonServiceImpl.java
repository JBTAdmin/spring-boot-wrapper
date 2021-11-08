package com.jbt.springbootflyway.service;

import com.jbt.springbootflyway.model.Person;
import com.jbt.springbootflyway.repository.PersonRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public String getPerson(Long id) {
    return personRepository.findById(id).get().getName();
  }

  @Override
  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }
}
