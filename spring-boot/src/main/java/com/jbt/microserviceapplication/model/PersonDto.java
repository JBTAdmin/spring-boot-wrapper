package com.jbt.microserviceapplication.model;

import com.jbt.microserviceapplication.entity.Email;
import com.jbt.microserviceapplication.entity.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class PersonDto {

    private Long id;
    private String name;
    private Date dob;
    private int age;
    private Gender gender;
    private Long height;
    private List<String> email;
}
