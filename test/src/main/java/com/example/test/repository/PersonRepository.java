package com.example.test.repository;

import com.example.test.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {
}
