package com.jbt.springbootredis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private Long id;
    private String name;
    private int age;
}