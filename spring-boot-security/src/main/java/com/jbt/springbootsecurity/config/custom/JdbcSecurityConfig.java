package com.jbt.springbootsecurity.config.custom;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
@ConditionalOnProperty(name = "test", havingValue = "true", matchIfMissing = false)
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {



    private DataSource datasource;

    public JdbcSecurityConfig(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select username,password,enabled, locked, expired from " +
                        "user where username = ?")
                .dataSource(datasource)
                .withDefaultSchema()
                .withUser("hello")
                .password("jbt")
                .roles("ADMIN");
    }
}
