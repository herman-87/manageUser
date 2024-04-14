package com.h87.manageUser.domain.users;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class UserState {
    @Embedded
    private UserEnabled isEnabled;
    @Embedded
    private AccountLocked isAccountLocked;
    @Embedded
    private CredentialsExpired isCredentialsExpired;
    @Embedded
    private AccountExpired isAccountExpired;
}
