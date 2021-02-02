package com.sadman.springsecurityrestjwt.repository;

import com.sadman.springsecurityrestjwt.model.ERole;
import com.sadman.springsecurityrestjwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}