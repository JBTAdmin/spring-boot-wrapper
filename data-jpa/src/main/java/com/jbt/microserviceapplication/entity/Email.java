package com.jbt.microserviceapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {

  @Id @GeneratedValue Long id;

  @NotNull String emailId;

  public Email(String emailId) {
    this.emailId = emailId;
  }
}
