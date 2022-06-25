package com.jbt.restrepository.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "PERSON")
public class Person {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;

  private int age;

  private LocalDate dob;

}
