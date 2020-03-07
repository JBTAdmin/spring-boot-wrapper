package com.jbt.microserviceapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"person"})
public class Email {

    @Id
    @GeneratedValue
     Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
     Person person;

     String emailId;
}
