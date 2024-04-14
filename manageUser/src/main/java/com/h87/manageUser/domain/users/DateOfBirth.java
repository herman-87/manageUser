package com.h87.manageUser.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class DateOfBirth {
    @Column(name = "c_date_of_birth")
    private LocalDate value;
}
