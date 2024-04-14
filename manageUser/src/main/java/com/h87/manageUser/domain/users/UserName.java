package com.h87.manageUser.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserName {
    @Column(name = "c_username")
    private String value;
}
