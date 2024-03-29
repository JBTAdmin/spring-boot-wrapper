package com.jbt.springboot.repository;

import com.jbt.springboot.entity.Person;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

  void deletePersonByNameAndDob(String name, LocalDate age);
}
