package com.jbt.springbootehcache.service;

import com.jbt.springbootehcache.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

  Person addPerson(Person person);

  Optional<Person> getPerson(Long id);

  Person updatePerson(Person person);

  void deletePerson(Person person);

  void deletePerson(Long id);

  List<Person> getAllPerson(int pageNumber, int pageSiz);

  List<Person> getAllPerson();
}
