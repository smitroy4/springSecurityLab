package com.smit.springSecurity.repository;

import com.smit.springSecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {

    Optional<Users> findByUsername(String username);
}
