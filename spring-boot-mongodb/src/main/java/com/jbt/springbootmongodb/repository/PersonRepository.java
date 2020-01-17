package com.jbt.springbootmongodb.repository;

import com.jbt.springbootmongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepository extends MongoRepository<Person, Long> {
}