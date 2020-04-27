package com.jbt.springbootmongodb.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Email implements Serializable {

  @Id Long id;

  @NotNull String emailId;

  public Email(String emailId) {
    this.emailId = emailId;
  }
}
