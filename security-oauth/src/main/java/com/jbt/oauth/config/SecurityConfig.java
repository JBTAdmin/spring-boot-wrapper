package com.jbt.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    //        return  new BCryptPasswordEncoder();
    return NoOpPasswordEncoder.getInstance();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("hello")
        .roles("ADMIN")
        .and()
        .withUser("user")
        .password("hello")
        .roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.requestMatchers()
        //				.authorizeRequests()
        //                .mvcMatchers("/").anonymous()
        .antMatchers("/admin")
        .and()
        .authorizeRequests();
    //				.and()
    //				.formLogin();

    // H2 console access related changes
    //        http.csrf().disable();
    //        http.headers().frameOptions().disable();
  }
}
