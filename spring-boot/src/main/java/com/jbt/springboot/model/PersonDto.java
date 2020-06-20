package com.jbt.springboot.model;

import com.jbt.springboot.entity.Person;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

  private Long id;

  @NotBlank(message = "Name can not be Blank")
  @Size(min = 10, max = 100, message = "Name size can only be between 10 to 100")
  private String name;

  private String qualification;

  private String address;

  private Date dob;

  @Min(value = 1, message = "Height value can not be less than or equal to 0FT")
  @Max(value = 10, message = "Height can not be more than 10FT")
  private Long height;


  public PersonDto(Person person) {
    this.id = person.getId();
    this.name = person.getName();
    this.qualification = person.getQualification();
    this.address = person.getAddress();
    this.dob = person.getDob();
    this.height = person.getHeight();
  }
}
