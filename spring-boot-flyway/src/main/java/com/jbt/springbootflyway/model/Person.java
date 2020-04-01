package com.jbt.springbootflyway.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
}