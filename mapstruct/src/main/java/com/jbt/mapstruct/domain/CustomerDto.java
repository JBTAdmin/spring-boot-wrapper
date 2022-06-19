package com.jbt.mapstruct.domain;

import com.jbt.mapstruct.entity.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

  // TODO through mapping convert it to string and vice versa
  private UUID id;
  private String customerName;
  private LocalDate dob;
  private Gender gender;
  private City city;
  private List<String> email;

  private DepartmentDto department;
}
