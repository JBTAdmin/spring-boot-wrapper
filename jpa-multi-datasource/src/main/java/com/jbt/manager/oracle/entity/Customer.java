package com.jbt.manager.oracle.entity;

import com.jbt.manager.mysql.entity.Gender;

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

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Temporal(TemporalType.DATE)
	Date dob;
	@Enumerated(EnumType.ORDINAL)
	Gender gender;

	@Builder.Default
	@Id
	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(
//			name = "UUID",
//			strategy = "org.hibernate.id.UUIDGenerator",
//	)
	private UUID id = UUID.randomUUID();
	private String name;

//	@OneToMany
//	private List<Email> emails;
}
