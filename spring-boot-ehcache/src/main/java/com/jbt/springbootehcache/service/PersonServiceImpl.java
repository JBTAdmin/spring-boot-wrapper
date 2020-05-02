package com.jbt.springbootehcache.service;

import com.jbt.springbootehcache.model.Person;
import com.jbt.springbootehcache.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person addPerson(Person person) {
    return personRepository.save(person);
  }

  @Cacheable("person")
  @Override
  public Optional<Person> getPerson(Long id) {
    System.out.println("Caching MISS");
    return personRepository.findById(1l);
  }

  @Override
  public Person updatePerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  public void deletePerson(Person person) {
    personRepository.delete(person);
  }

  @Override
  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }

  @Override
  public List<Person> getAllPerson(int pageNumber, int pageSize) {
    return personRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }

  //    @Cacheable("persons")
  @Override
  public List<Person> getAllPerson() {
    return personRepository.findAll();
  }
}
