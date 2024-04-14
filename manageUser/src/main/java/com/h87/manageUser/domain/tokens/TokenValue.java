package com.h87.manageUser.domain.tokens;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TokenValue {
    @Column(name = "c_value")
    private String value;
}
