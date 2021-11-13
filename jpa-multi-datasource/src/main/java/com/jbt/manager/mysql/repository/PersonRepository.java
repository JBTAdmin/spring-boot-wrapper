package com.jbt.manager.mysql.repository;

import com.jbt.manager.mysql.entity.Person;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {}
