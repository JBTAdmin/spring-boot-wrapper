package com.jbt.springbootsecurity.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@ConditionalOnProperty(name = "test", havingValue = "true", matchIfMissing = false)
public class LdapSecurityConfig extends BaseSecurityConfig {
}
