package com.h87.manageUser.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LastName {
    @Column(name = "c_lastname")
    private String value;
}
