package com.h87.manageUser.repository;

import com.h87.manageUser.domain.tokens.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenSpringRepository extends JpaRepository<Token, String> {
    Optional<Token> findByValueToken(String value);
}
