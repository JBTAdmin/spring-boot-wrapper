package com.jbt.microserviceapplication.repository;

import com.jbt.microserviceapplication.entity.Person;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  void deletePersonByNameAndDob(String name, Date age);

  // Method with query
  // Method picking only some column of the table
  // Method with where clause
  // Method with join
  // Method with group by
  // Method with having
  // Method with order by
  // Method with limit
  // Method with offset
  // Method with distinct
  // Method with like
  // Method with in
  // Method with between
  // Method with count
  // Method with max
  // Method with min
  // Method with sum
  // Method with avg
  // Method with count distinct
  // Method with exists
  // Method with not exists
  // Method with all
  // Method with some
}
