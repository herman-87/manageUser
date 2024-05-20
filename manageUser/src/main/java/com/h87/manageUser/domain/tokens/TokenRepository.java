package com.h87.manageUser.domain.tokens;

public interface TokenRepository {
    Token save(Token generatedToken);
}
