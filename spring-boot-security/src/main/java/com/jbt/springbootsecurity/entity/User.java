package com.jbt.springbootsecurity.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
