package com.jbt.microserviceapplication.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"email"})
@EqualsAndHashCode(exclude = "{email}")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String qualification;

    private String address;

    @Temporal(TemporalType.DATE)
    Date dob;

    @Enumerated(EnumType.ORDINAL)
    Gender gender;

//    private List<PersonRole> roles;

    private Long height;

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "person_id")
    private List<Email> email = new ArrayList<>();
}