package com.h87.manageUser.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FirstName {
    @Column(name = "c_firstname")
    private String value;
}
