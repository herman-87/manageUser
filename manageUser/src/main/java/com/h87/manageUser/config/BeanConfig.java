package com.h87.manageUser.config;

import com.h87.manageUser.domain.roles.RoleRepository;
import com.h87.manageUser.domain.users.UserRepository;
import com.h87.manageUser.repository.RoleSpringRepository;
import com.h87.manageUser.repository.UserSpringRepository;
import com.h87.manageUser.service.DefaultRoleRepository;
import com.h87.manageUser.service.DefaultUserRepository;
import lombok.RequiredArgsConstructor;
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

    @Bean
    public RoleRepository roleRepository(RoleSpringRepository roleSpringRepository) {
        return new DefaultRoleRepository(roleSpringRepository);
    }

    @Bean
    public UserRepository userRepository(UserSpringRepository userSpringRepository) {
        return new DefaultUserRepository(userSpringRepository);
    }
}
