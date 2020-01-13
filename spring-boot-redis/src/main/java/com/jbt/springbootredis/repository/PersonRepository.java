package com.jbt.springbootredis.repository;

import com.jbt.springbootredis.model.Person;

import java.util.Map;

public interface PersonRepository {
    public void save(Person person);
    public Map<Long, Person> findAll();
    public Person findById(Long id);
}