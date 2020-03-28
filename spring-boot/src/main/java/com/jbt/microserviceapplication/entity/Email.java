package com.jbt.microserviceapplication.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Email {

     @Id
     @GeneratedValue
     Long id;

//     public Email(@NotNull String emailId) {
//          this.emailId = emailId;
//     }

     @NotNull
     String emailId;

     public Email(String s) {
     }
}
