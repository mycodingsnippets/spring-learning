package com.thenerdyaditya.testStructure.repository;

import com.thenerdyaditya.testStructure.models.ERole;
import com.thenerdyaditya.testStructure.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
