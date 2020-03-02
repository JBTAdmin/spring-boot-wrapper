package com.jbt.springbootehcache.model;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dob;
    private int age;
}