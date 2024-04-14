package com.h87.manageUser.domain.scopes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ScopeName {
    @Column(name = "c_name")
    private String value;
}
