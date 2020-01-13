package com.jbt.springbootredis.repository;

import com.jbt.springbootredis.model.Person;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository{

    public PersonRepositoryImpl(RedisTemplate<Long, Person> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    RedisTemplate<Long, Person> redisTemplate;
    HashOperations hashOperations;

    public void save(Person person){
        hashOperations.put("PERSON", person.getId(), person);
    }
    public Map<Long, Person> findAll(){
        return hashOperations.entries("PERSON");
    }
    public Person findById(Long id){
        return (Person) hashOperations.get("PERSON",id);
    }
}