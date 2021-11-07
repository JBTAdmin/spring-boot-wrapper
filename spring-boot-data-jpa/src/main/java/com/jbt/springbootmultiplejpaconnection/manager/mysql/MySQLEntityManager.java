package com.jbt.springbootmultiplejpaconnection.manager.mysql;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class MySQLEntityManager {

  @Bean
  public LocalContainerEntityManagerFactoryBean userEntityManager(
      EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
    // entityManagerFactoryBuilder.dataSource()
    return null;
  }
}
