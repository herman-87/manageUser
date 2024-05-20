package com.h87.manageUser.config;

import com.h87.manageUser.domain.roles.RoleRepository;
import com.h87.manageUser.domain.tokens.TokenRepository;
import com.h87.manageUser.domain.users.UserRepository;
import com.h87.manageUser.repository.RoleSpringRepository;
import com.h87.manageUser.repository.TokenSpringRepository;
import com.h87.manageUser.repository.UserSpringRepository;
import com.h87.manageUser.service.DefaultRoleRepository;
import com.h87.manageUser.service.DefaultTokenRepository;
import com.h87.manageUser.service.DefaultUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final UserDetailsService userDetailsService;
    @Value("${default.activation-code.length}")
    private final Integer activationCodeLength;
    @Value("${default.activation-code.expiration-minutes}")
    private final Integer activationCodeExpirationMinutes;
    @Value("${default.activation-code.characters}")
    private final String activationCodeCharacters;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Domain Repositories
    @Bean
    public RoleRepository roleRepository(RoleSpringRepository roleSpringRepository) {
        return new DefaultRoleRepository(roleSpringRepository);
    }

    @Bean
    public UserRepository userRepository(UserSpringRepository userSpringRepository) {
        return new DefaultUserRepository(userSpringRepository);
    }

    @Bean
    public TokenRepository tokenRepository(TokenSpringRepository tokenSpringRepository) {
        return new DefaultTokenRepository(tokenSpringRepository);
    }

    //environment variables
    @Bean
    public Integer activationCodeLength() {
        return activationCodeLength;
    }

    @Bean
    public String activationCodeCharacters() {
        return activationCodeCharacters;
    }

    @Bean
    public Integer activationCodeExpirationMinutes() {
        return activationCodeExpirationMinutes;
    }
}
