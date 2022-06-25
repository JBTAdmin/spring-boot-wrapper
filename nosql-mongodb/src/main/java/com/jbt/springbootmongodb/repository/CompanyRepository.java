package com.jbt.springbootmongodb.repository;

import com.jbt.springbootmongodb.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends MongoRepository<Company, Long> {
    List<Company> findByName(String name);

    @Query("{'company.id': ?0}")
    Optional<Company> findById(String id);

    String deleteByName(String name);
}