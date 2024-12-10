package com.assignment.userservice.security.repository;

import com.assignment.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringSecurityUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
}
