package com.jbt.manager.mysql.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @Temporal(TemporalType.DATE)
  Date dob;
  @Enumerated(EnumType.ORDINAL)
  Gender gender;



//  @Id
//  @GeneratedValue(generator = "UUID")
//TODO need to identify the meaning of each
  @Id
  @GeneratedValue(generator = "UUID")
//  @GenericGenerator(name = "uuid2", strategy = "uuid2")
//  @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
  @Type(type = "uuid-char")
  private UUID id;

  private String name;
  private String qualification;
  private String address;
  private Long height;
}
