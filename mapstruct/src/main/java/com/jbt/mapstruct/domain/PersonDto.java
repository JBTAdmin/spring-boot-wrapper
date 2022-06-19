package com.jbt.mapstruct.domain;

import com.jbt.mapstruct.entity.Gender;

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
public class PersonDto {

  private UUID id;
  private String personName;
  private String qualification;
  private String address;
  private Date dob;
  private Gender gender;
  private Long height;
}
