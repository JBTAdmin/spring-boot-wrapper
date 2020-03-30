package com.jbt.springbootsecurity.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;

    private String password;
    private boolean enabled;
    private boolean expired;
    private boolean locked;
    private boolean credentialExpired;


    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userName")
    private List<Authorities> authorities;
}