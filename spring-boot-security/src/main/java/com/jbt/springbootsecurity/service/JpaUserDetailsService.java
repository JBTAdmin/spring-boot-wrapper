package com.jbt.springbootsecurity.service;

import com.jbt.springbootsecurity.entity.User;
import com.jbt.springbootsecurity.model.CustomUserDetails;
import com.jbt.springbootsecurity.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

  private UserRepository userRepository;

  public JpaUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findById(username);

    user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

    return new CustomUserDetails(user.get());
  }
}
