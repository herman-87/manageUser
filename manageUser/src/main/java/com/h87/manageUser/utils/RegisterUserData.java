package com.h87.manageUser.utils;

import com.h87.manageUser.domain.users.Genre;

import java.time.LocalDate;

public record RegisterUserData(
        String emailAddress,
        String password,
        String countryCode,
        String number,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        Genre genre

) {
}
