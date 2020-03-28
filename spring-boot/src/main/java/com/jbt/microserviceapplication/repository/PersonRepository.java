package com.jbt.microserviceapplication.repository;


import com.jbt.microserviceapplication.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public void deletePersonByNameAndDob(String name, Date age);
}