package com.jbt.springboot.entity;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @Id
  @GeneratedValue(generator = "UUID")
  @Type(type = "uuid-char")
  private UUID id;

  private LocalDate dob;

  // TODO : @NotEmpty
  @Enumerated(EnumType.ORDINAL)
  private Gender gender;

  private String name;

  private String qualification;

  private String address;

  private Long height;
}
