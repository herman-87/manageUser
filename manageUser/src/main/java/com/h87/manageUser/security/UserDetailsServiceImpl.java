package com.h87.manageUser.security;

import com.h87.manageUser.repository.UserSpringRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserSpringRepository userSpringRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSpringRepository.findByEmailValue(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
