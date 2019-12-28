package com.jbt.nosql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Department")
public class Person implements Serializable {

    @Id
    private String name;
    private int age;

}