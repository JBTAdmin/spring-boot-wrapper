package com.jbt.springbootsecurity.model;

import com.jbt.springbootsecurity.entity.User;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

  private final String username;
  private final Set<GrantedAuthority> authorities;
  private final boolean accountNonExpired;
  private final boolean accountNonLocked;
  private final boolean credentialsNonExpired;
  private final boolean enabled;
  private String password;

  public CustomUserDetails(User user) {
    this.username = user.getUserName();
    this.password = user.getPassword();
    this.enabled = user.isEnabled();
    this.accountNonExpired = !user.isExpired();
    this.accountNonLocked = !user.isLocked();
    this.credentialsNonExpired = !user.isCredentialExpired();
    this.authorities =
        user.getAuthorities().stream()
            .map(authorities1 -> authorities1.getAuthority())
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toSet());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
