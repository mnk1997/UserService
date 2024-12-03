package com.assignment.userservice.repository;

import com.assignment.userservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByValue(String name);
    Optional<Role> findByValueEqualsIgnoreCase(String role);
}
