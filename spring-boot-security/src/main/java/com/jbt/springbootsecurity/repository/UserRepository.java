package com.jbt.springbootsecurity.repository;

import com.jbt.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
