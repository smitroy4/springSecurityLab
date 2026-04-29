package com.smit.springSecurity.repository;

import com.smit.springSecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {

//    Optional<Users> findByUsername(String username);

    Optional<Users> findByEmail(String email);
}
