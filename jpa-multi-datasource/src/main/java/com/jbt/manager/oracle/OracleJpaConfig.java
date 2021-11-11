package com.jbt.manager.oracle;

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
    basePackages = "com.jbt.manager.oracle",
    entityManagerFactoryRef = "oracleEntityManager",
    transactionManagerRef = "oracleTransactionManager")
public class OracleJpaConfig extends BaseJpaConfig {

  @Bean
  @ConfigurationProperties(prefix = "jpa.datasource.oracle")
  public DataSource oracleDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean oracleEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(oracleDataSource());
    em.setPackagesToScan("com.jbt.manager.oracle.entity");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.setJpaProperties(jpaProperties("org.hibernate.dialect.Oracle10gDialect"));
    return em;
  }

  @Bean
  public PlatformTransactionManager oracleTransactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(oracleEntityManager().getObject());
    return transactionManager;
  }
}
