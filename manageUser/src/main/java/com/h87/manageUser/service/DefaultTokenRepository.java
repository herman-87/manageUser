package com.h87.manageUser.service;

import com.h87.manageUser.domain.tokens.Token;
import com.h87.manageUser.domain.tokens.TokenRepository;
import com.h87.manageUser.repository.TokenSpringRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultTokenRepository implements TokenRepository {
    private final TokenSpringRepository tokenSpringRepository;

    @Override
    public Token save(Token token) {
        return tokenSpringRepository.save(token);
    }
}
