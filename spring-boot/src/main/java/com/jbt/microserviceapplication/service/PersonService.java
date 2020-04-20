package com.jbt.microserviceapplication.service;

import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.model.PersonDto;
import java.util.List;
import java.util.Optional;

public interface PersonService {

  Person savePerson(PersonDto person);

  Optional<Person> getPerson(Long id);

  Person updatePerson(Person person);

  void deletePersonByNameAndAge(PersonDto person);

  void deletePersonById(Long id);

  List<Person> getAllPersons(int pageNumber, int pageSiz);

  List<PersonDto> getAllPersons();
}
