package com.h87.manageUser.domain.users;

import com.h87.userManagementMonolithicApi.domain.commons.EmailAddress;
import com.h87.userManagementMonolithicApi.domain.commons.EntityBase;
import com.h87.userManagementMonolithicApi.domain.commons.PhoneNumber;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class User extends EntityBase {
    @Embedded
    private UserName userName;

    @Embedded
    private EmailAddress emailAddress;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private FirstName firstName;

    @Embedded
    private LastName lastName;

    @Embedded
    private DateOfBirth dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "c_genre")
    private Genre genre;
}
