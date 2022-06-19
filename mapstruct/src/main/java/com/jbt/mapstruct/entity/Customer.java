package com.jbt.mapstruct.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  private String dob;

  private Gender gender;

  private State state;

  @Builder.Default private UUID id = UUID.randomUUID();

  private Department department;
  private String name;
}
