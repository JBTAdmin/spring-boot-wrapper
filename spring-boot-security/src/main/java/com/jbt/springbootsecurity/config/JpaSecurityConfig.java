package com.jbt.springbootsecurity.config;

import com.jbt.springbootsecurity.service.JpaUserDetailsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@ConditionalOnProperty(name = "test", havingValue = "true", matchIfMissing = true)
public class JpaSecurityConfig extends BaseSecurityConfig {

  private JpaUserDetailsService jpaUserDetailsService;

  public JpaSecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
    this.jpaUserDetailsService = jpaUserDetailsService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(jpaUserDetailsService);
  }
}
