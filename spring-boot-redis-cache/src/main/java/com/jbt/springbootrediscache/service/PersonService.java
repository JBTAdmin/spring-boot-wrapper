package com.jbt.springbootrediscache.service;

import com.jbt.springbootrediscache.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

  Person createPerson(Person person);

  Optional<Person> getPerson(Long id);

  Person editPerson(Person person);

  void deletePerson(Long id);

  List<Person> getAllPersons();
}
