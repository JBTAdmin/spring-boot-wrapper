package com.jbt.springbootmongodb.repository;

import com.jbt.springbootmongodb.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<Email, Long> {}
