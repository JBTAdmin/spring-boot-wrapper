package com.jbt.springboot.repository;

import com.jbt.springboot.entity.Person;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  void deletePersonByNameAndDob(String name, Date age);
}
