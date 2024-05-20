package com.h87.manageUser.domain.roles;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RoleDescription {
    @Column(name = "c_description")
    private String value;
}
