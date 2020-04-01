package com.jbt.springbootflyway.service;


import com.jbt.springbootflyway.model.Person;

import java.util.List;

public interface PersonService {

    String getPerson(Long id);

    List<Person> getAllPersons();
}
