package com.jbt.microserviceapplication.repository;


import com.jbt.microserviceapplication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person1Repository extends MongoRepository<Person, Long> {
//    public interface PersonRepository extends JpaRepository<Person, Long> {
}