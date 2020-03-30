package com.jbt.springbootsecurity.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "test", havingValue = "true", matchIfMissing = false)
public class BaseSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
//        return  new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("hello").roles("ADMIN")
                .and()
                .withUser("user")
                .password("hello")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .mvcMatchers("/console/**").anonymous()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .mvcMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin();
// H2 console access related changes
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //Used for h2 console access
        web.ignoring().antMatchers("/console/**");
    }
}
