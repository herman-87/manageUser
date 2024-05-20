package com.h87.manageUser.repository;

import com.h87.manageUser.domain.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleSpringRepository extends JpaRepository<Role, String> {
    Optional<Role> findRoleByNameValue(String name);
}
