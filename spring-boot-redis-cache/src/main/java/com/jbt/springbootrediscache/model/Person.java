package com.jbt.springbootrediscache.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Person implements Serializable {

    @Id
    private Long id;
    private String name;
    private int age;
}