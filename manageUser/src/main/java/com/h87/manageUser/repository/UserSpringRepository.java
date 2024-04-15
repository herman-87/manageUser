package com.h87.manageUser.repository;

import com.h87.manageUser.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSpringRepository extends JpaRepository<User, String> {
    Optional<User> findByEmailValue(String email);
}
