package com.jbt.mapstruct.entity;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  Date dob;

  Gender gender;

  private UUID id;

  private String name;

  private String qualification;

  private String address;

  private Long height;
}
