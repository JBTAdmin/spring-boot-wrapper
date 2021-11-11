package com.jbt.springbootcachehazelcast.service;

import com.jbt.springbootcachehazelcast.model.Person;
import java.util.List;

public interface PersonService {

  Person createPerson(Person person);

  String getPerson(Long id);

  Person editPerson(Person person);

  void deletePerson(Person person);

  void deletePerson(Long id);

  List<Person> getAllPersons(int pageNumber, int pageSiz);

  List<Person> getAllPersons();
}
