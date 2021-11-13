package com.jbt.manager.oracle.repository;

import com.jbt.manager.oracle.entity.Email;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@PropertySource({"classpath:persistence-multiple-db.properties"})
//@EnableJpaRepositories(
//    basePackages = "com.jbt.springbootmultiplejpaconnection.manager.oracle.entity",
//    entityManagerFactoryRef = "userEntityManager",
//    transactionManagerRef = "userTransactionManager")
public interface EmailRepository extends JpaRepository<Email, Long> {

  List<Email> findAllByPersonId(UUID personId);
}
