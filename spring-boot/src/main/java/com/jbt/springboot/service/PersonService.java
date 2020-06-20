package com.jbt.springboot.service;

import com.jbt.springboot.entity.Person;
import com.jbt.springboot.model.PersonDto;
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
