package com.jbt.repository;

import com.jbt.manager.oracle.entity.Email;
import java.util.List;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource({"classpath:persistence-multiple-db.properties"})
@EnableJpaRepositories(
    basePackages = "com.jbt.springbootmultiplejpaconnection.manager.oracle.entity",
    entityManagerFactoryRef = "userEntityManager",
    transactionManagerRef = "userTransactionManager")
public interface EmailRepository extends JpaRepository<Email, Long> {

  List<Email> findAllByPersonId(Long personId);
}
