package com.jbt.springbootmongodb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Person implements Serializable {

  @Id private Long id;

  private String name;

  private Date dob;

  private Gender gender;

  private List<Email> email = new ArrayList<>();
}
