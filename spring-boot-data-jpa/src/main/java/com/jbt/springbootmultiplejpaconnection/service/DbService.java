package com.jbt.springbootmultiplejpaconnection.service;

import com.jbt.springbootmultiplejpaconnection.manager.mysql.entity.Person;
import com.jbt.springbootmultiplejpaconnection.model.PersonDto;
import java.util.List;
import java.util.Optional;

public interface DbService {

  Person createPerson(PersonDto person);

  Optional<Person> getPerson(Long id);

  Person editPerson(PersonDto person);

  void deletePersonById(Long id);

  List<Person> getAllPersons(int pageNumber, int pageSiz);

  List<PersonDto> getAllPersons();
}
