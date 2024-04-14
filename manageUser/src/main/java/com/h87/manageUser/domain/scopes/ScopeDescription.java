package com.h87.manageUser.domain.scopes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ScopeDescription {
    @Column(name = "c_description")
    private String value;
}
