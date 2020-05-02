package com.jbt.springbootredis.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Person implements Serializable {

  private Long id;
  private String name;
  private int age;
}
