package com.jbt.manager.h2;

import com.jbt.manager.BaseJpaConfig;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

// @PropertySource({"classpath:db.properties"}) // In case you want to use different properties
// file.
@Configuration
@EnableJpaRepositories(
    basePackages = "com.jbt.manager.h2",
    entityManagerFactoryRef = "h2EntityManager",
    transactionManagerRef = "h2TransactionManager")
public class H2JpaConfig extends BaseJpaConfig {

  @Bean
  @ConfigurationProperties(prefix = "jpa.datasource.h2")
  public DataSource h2DataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean h2EntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(h2DataSource());
    em.setPackagesToScan("com.jbt.manager.h2.entity");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.setJpaProperties(jpaProperties("org.hibernate.dialect.H2Dialect"));
    return em;
  }

  @Bean
  public PlatformTransactionManager h2TransactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(h2EntityManager().getObject());
    return transactionManager;
  }
}
