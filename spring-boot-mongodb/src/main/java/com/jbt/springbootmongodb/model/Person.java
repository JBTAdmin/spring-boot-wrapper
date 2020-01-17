package com.jbt.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("person")
public class Person {

    @Id
    private Long id;
    private String name;
    private int age;
}