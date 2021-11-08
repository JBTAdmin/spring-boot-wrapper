package com.jbt.springbootmultiplejpaconnection.repository;

import com.jbt.springbootmultiplejpaconnection.manager.mysql.entity.Person;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource({"classpath:persistence-multiple-db.properties"})
@EnableJpaRepositories(
    basePackages = "com.jbt.springbootmultiplejpaconnection.manager.mysql.entity",
    entityManagerFactoryRef = "userEntityManager",
    transactionManagerRef = "userTransactionManager")
public interface PersonRepository extends JpaRepository<Person, Long> {}
