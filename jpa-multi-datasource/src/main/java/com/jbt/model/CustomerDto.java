package com.jbt.model;

import com.jbt.manager.mysql.entity.Gender;
import com.jbt.manager.mysql.entity.Person;
import com.jbt.manager.oracle.entity.Email;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

  //TODO through mapping convert it to string and vice versa
  private UUID id;
  private String name;
  private Date dob;
  private Gender gender;

  private List<String> email;

  public CustomerDto(Person person) {}

  public CustomerDto(Person person, List<Email> emails) {
    this.name = person.getName();
    this.dob = person.getDob();
    this.gender = person.getGender();
    this.email = emails.stream().map(email1 -> email1.getEmailId()).collect(Collectors.toList());
  }
}
