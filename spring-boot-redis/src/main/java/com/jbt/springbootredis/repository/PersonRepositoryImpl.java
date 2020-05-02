package com.jbt.springbootredis.repository;

import com.jbt.springbootredis.model.Person;
import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

  RedisTemplate<Long, Person> redisTemplate;
  HashOperations hashOperations;
  public PersonRepositoryImpl(RedisTemplate<Long, Person> redisTemplate) {
    this.redisTemplate = redisTemplate;
    hashOperations = redisTemplate.opsForHash();
  }

  public void save(Person person) {
    hashOperations.put("PERSON", person.getId(), person);
  }

  public Map<Long, Person> findAll() {
    return hashOperations.entries("PERSON");
  }

  public Person findById(Long id) {
    return (Person) hashOperations.get("PERSON", id);
  }
}
