package com.jbt.springbootrediscache.service;

import com.jbt.springbootrediscache.model.Person;
import com.jbt.springbootrediscache.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(
    cacheNames = {"person"},
    keyGenerator = "customKey")
public class PersonServiceImpl implements PersonService {

  @Autowired private PersonRepository personRepository;

  @Override
  @Caching(
      put = {@CachePut},
      evict = {@CacheEvict(key = "'all'")})
  public Person createPerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  @Cacheable(unless = "#result != null")
  public Optional<Person> getPerson(Long id) {
    return personRepository.findById(id);
  }

  @Override
  @Caching(evict = {@CacheEvict(), @CacheEvict(key = "'all'")})
  public Person editPerson(Person person) {
    return personRepository.save(person);
  }

  @Override
  @Caching(evict = {@CacheEvict, @CacheEvict(key = "'all'")})
  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }

  @Override
  @Cacheable
  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  @Scheduled(fixedDelay = 30000)
  @CacheEvict(cacheNames = "person", allEntries = true)
  public void cacheEvict() {
    System.out.println("Evicting Person Cache");
  }
}
