package com.jbt.manager.mysql;

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
    basePackages = "com.jbt.manager.mysql",
    entityManagerFactoryRef = "mysqlEntityManager",
    transactionManagerRef = "mysqlTransactionManager")
public class MySqlJpaConfig extends BaseJpaConfig {

  @Bean
  @ConfigurationProperties(prefix = "jpa.datasource.mysql")
  public DataSource mysqlDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean mysqlEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(mysqlDataSource());
    em.setPackagesToScan("com.jbt.manager.mysql.entity");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.setJpaProperties(jpaProperties("org.hibernate.dialect.MySQL8Dialect"));
    return em;
  }

  @Bean
  public PlatformTransactionManager mysqlTransactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(mysqlEntityManager().getObject());
    return transactionManager;
  }
}
