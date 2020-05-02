package com.jbt.springbootsecurity.config;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@ConditionalOnProperty(name = "test", havingValue = "true", matchIfMissing = false)
public class JdbcSecurityConfig extends BaseSecurityConfig {

  private DataSource datasource;

  public JdbcSecurityConfig(DataSource datasource) {
    this.datasource = datasource;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
        .dataSource(datasource)
        .withDefaultSchema()
        .withUser("hello")
        .password("jbt")
        .roles("ADMIN");
  }
}
