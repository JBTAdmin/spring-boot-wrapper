package com.jbt.oauth.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  private String firstName;
  private String lastName;
}
