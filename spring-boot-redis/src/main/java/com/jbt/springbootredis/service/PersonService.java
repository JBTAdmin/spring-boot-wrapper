package com.jbt.springbootredis.service;

import com.jbt.springbootredis.model.Person;
import java.util.List;

public interface PersonService {

  Person createPerson(Person person);

  Person getPerson(Long id);

  List<Person> getAllPersons();
}
