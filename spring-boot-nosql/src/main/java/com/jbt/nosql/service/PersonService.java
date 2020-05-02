package com.jbt.nosql.service;

import com.jbt.nosql.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

  Person createPerson(Person person);

  Optional<Person> getPerson(String id);

  Person editPerson(Person person);

  void deletePerson(Person person);

  void deletePerson(String id);

  List<Person> getAllPersons(int pageNumber, int pageSiz);

  List<Person> getAllPersons();
}
