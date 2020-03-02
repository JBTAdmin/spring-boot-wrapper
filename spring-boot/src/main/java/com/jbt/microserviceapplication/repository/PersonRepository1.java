package com.jbt.microserviceapplication.repository;


import com.jbt.microserviceapplication.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository1 extends JpaRepository<Person, Long> {
}