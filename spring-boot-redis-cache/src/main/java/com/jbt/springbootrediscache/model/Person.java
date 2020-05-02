package com.jbt.springbootrediscache.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person implements Serializable {

  @Id private Long id;
  private String name;
  private int age;
}
