package com.jbt.microserviceapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private int age;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    private Long height;


    @OneToMany (cascade = CascadeType.ALL, mappedBy = "person_id") // mappedBy option is not
    // required
    // here
//    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private List<Email> email;
}