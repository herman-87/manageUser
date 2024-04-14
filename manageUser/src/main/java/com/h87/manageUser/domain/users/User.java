package com.h87.manageUser.domain.users;

import com.h87.manageUser.domain.commons.EmailAddress;
import com.h87.manageUser.domain.commons.EntityBase;
import com.h87.manageUser.domain.commons.PhoneNumber;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class User extends EntityBase implements Principal, UserDetails {

    @Embedded
    private UserName userName;

    @Embedded
    private EmailAddress emailAddress;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Password password;

    @Embedded
    private FirstName firstName;

    @Embedded
    private LastName lastName;

    @Embedded
    private DateOfBirth dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "c_genre")
    private Genre genre;

    @Builder.Default
    @Embedded
    private UserState state = UserState.builder()
            .isCredentialsExpired(new CredentialsExpired(false))
            .isAccountLocked(new AccountLocked(false))
            .isAccountExpired(new AccountExpired(false))
            .isEnabled(new UserEnabled(true))
            .build();

    @Override
    public String getName() {
        return emailAddress.getValue();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password.getValue();
    }

    @Override
    public String getUsername() {
        return emailAddress.getValue();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !state.getIsAccountExpired().isValue();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !state.getIsAccountLocked().isValue();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !state.getIsCredentialsExpired().isValue();
    }

    @Override
    public boolean isEnabled() {
        return state.getIsEnabled().isValue();
    }
}
