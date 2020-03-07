package com.jbt.microserviceapplication.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"email"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @Temporal(TemporalType.DATE)
    Date dob;

    int age;

    @Enumerated(EnumType.ORDINAL)
    Gender gender;

    Long height;

    @OneToMany (mappedBy = "person", cascade = CascadeType.ALL,orphanRemoval = true)
    List<Email> email = new ArrayList<>();

    public void addEmail(Email email1) {
        if(email == null){
            email = new ArrayList<>();
        }
        email.add( email1 );
        email1.setPerson( this );
    }

    public void removeEmail(Email email1) {
        email.remove( email1 );
        email1.setPerson( null );
    }
}