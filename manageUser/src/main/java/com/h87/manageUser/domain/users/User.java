package com.h87.manageUser.domain.users;

import com.h87.manageUser.domain.commons.EmailAddress;
import com.h87.manageUser.domain.commons.EntityBase;
import com.h87.manageUser.domain.commons.PhoneNumber;
import com.h87.manageUser.domain.roles.Role;
import com.h87.manageUser.domain.roles.RoleName;
import com.h87.manageUser.domain.roles.RoleRepository;
import com.h87.manageUser.domain.tokens.Token;
import com.h87.manageUser.domain.tokens.TokenCreatedAt;
import com.h87.manageUser.domain.tokens.TokenExpiredDate;
import com.h87.manageUser.domain.tokens.TokenRepository;
import com.h87.manageUser.domain.tokens.TokenValue;
import com.h87.manageUser.utils.ManageUserErrorCode;
import com.h87.manageUser.utils.RegisterUserData;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
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
            .isEnabled(new UserEnabled(false))
            .build();

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_user_scope",
            joinColumns = @JoinColumn(name = "c_user"),
            inverseJoinColumns = @JoinColumn(name = "c_scope")
    )
    private List<Role> roles = new ArrayList<>();

    public static User createUser(RegisterUserData registerUserData,
                                  PasswordEncoder passwordEncoder,
                                  RoleRepository roleRepository,
                                  UserRepository userRepository) throws RoleNotFoundException {
        Role role = roleRepository.findRoleByName(new RoleName("USER"))
                .orElseThrow(() -> new RoleNotFoundException(ManageUserErrorCode.ROLE_NOT_FOUND));
        User user = User.builder()
                .firstName(new FirstName(registerUserData.firstName()))
                .lastName(new LastName(registerUserData.lastName()))
                .emailAddress(new EmailAddress(registerUserData.emailAddress()))
                .password(new Password(passwordEncoder.encode(registerUserData.password())))
                .roles(List.of(role))
                .build();
        return userRepository.save(user);
    }

    public static String generateActivationCode(Integer activationCodeLength, String activationCodeCharacters) {
        StringBuilder activationCodeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < activationCodeLength; i++) {
            int randomIndex = secureRandom.nextInt(activationCodeCharacters.length());
            activationCodeBuilder.append(activationCodeCharacters.charAt(randomIndex));
        }
        return activationCodeBuilder.toString();
    }

    @Override
    public String getName() {
        return emailAddress.getValue();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(scope -> new SimpleGrantedAuthority(scope.getName().getValue()))
                .toList();
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

    public Token generatedToken(String activationCode,
                               Integer activationCodeExpirationMinutes,
                               TokenRepository tokenRepository) {
        Token generatedToken = Token.builder()
                .value(new TokenValue(activationCode))
                .createdAt(TokenCreatedAt.builder().value(LocalDateTime.now()).build())
                .expiredDate(
                        TokenExpiredDate.builder()
                                .value(LocalDateTime.now().plusMinutes(activationCodeExpirationMinutes))
                                .build()
                )
                .user(this)
                .build();
        return tokenRepository.save(generatedToken);
    }
}
