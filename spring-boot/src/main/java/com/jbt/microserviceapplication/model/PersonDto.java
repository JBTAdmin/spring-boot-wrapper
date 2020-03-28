package com.jbt.microserviceapplication.model;

import com.jbt.microserviceapplication.entity.Gender;
import com.jbt.microserviceapplication.entity.Person;
import com.jbt.microserviceapplication.entity.PersonRole;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
//@Builder
public class PersonDto {

    private Long id;
    private String name;
    private String qualification;
//    private int age; // WILL BE CALCULATED ON UI ONLY AND NOT SAVED IN DB
    private String address;
    private Date dob;  // NEEDS TO ADD ON UI
    private Gender gender;
    private List<PersonRole> personRoles;  // Check box of ADMIN-USER-CONTRACTOR
    private Long height;

    @Builder
    public PersonDto(String name, String qualification, String address, Date dob, Gender gender, List<PersonRole> personRoles, Long height, List<String> email) {
        this.name = name;
        this.qualification = qualification;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.personRoles = personRoles;
        this.height = height;
        this.email = email;
    }

    private List<String> email;

    public PersonDto(Person person){
        this.name = person.getName();
        this.qualification = person.getQualification();
        this.address = person.getAddress();
        this.dob = person.getDob();
        this.gender = person.getGender();

        this.height = person.getHeight();
//        this.email = person.getEmail();
    }

}
