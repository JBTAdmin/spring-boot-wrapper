package com.jbt.nosql.service;

import com.jbt.nosql.model.Person;
import com.jbt.nosql.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired private PersonRepository personRepository;

  @Override
  public Person createPerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  @Cacheable("personWithId")
  public Optional<Person> getPerson(String id) {
    return personRepository.findById(id);
  }

  @Override
  public Person editPerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  public void deletePerson(Person person) {
    personRepository.delete(person);
  }

  @Override
  public void deletePerson(String id) {
    personRepository.deleteById(id);
  }

  @Override
  @Cacheable("AllPersonPageSize")
  public List<Person> getAllPersons(int pageNumber, int pageSize) {
    return personRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }

  @Override
  @Cacheable("AllPerson")
  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }
}
