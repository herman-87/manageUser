package com.h87.manageUser.domain.commons;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmailAddress {
    @Column(name = "c_email")
    private String value;
}
