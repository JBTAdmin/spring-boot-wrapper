package com.jbt.model;

import com.jbt.manager.mysql.entity.Gender;
import com.jbt.manager.mysql.entity.Person;
import com.jbt.manager.oracle.entity.Email;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

  private Long id;
  private String name;
  private String qualification;
  private String address;
  private Date dob;
  private Gender gender;
  private Long height;

  private List<String> email;

  public PersonDto(Person person) {}

  public PersonDto(Person person, List<Email> emails) {
    this.name = person.getName();
    this.qualification = person.getQualification();
    this.address = person.getAddress();
    this.dob = person.getDob();
    this.gender = person.getGender();
    this.email = emails.stream().map(email1 -> email1.getEmailId()).collect(Collectors.toList());
  }
}
