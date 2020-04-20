package com.jbt.springbootflyway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {

  @Id @GeneratedValue private Long id;
  private String name;
  private int age;
}
