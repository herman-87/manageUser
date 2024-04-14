package com.h87.manageUser.domain.scopes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class RoleName {
    @Column(name = "c_name")
    private String value;
}
