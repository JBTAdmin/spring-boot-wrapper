package com.jbt.service;

import com.jbt.manager.mysql.entity.Person;
import com.jbt.model.CustomerDto;
import com.jbt.model.PersonDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DbService {

  PersonDto createPerson(PersonDto person);

  Optional<Person> getPerson(UUID id);

  Person editPerson(PersonDto person);

  void deletePersonById(UUID id);

  List<Person> getAllPersons(int pageNumber, int pageSiz);

  List<PersonDto> getAllPersons();

  List<CustomerDto> getAllCustomer();

  CustomerDto createCustomer(CustomerDto customerDto);

  CustomerDto getCustomer(UUID id);
}
