package com.h87.manageUser.security;

import com.h87.manageUser.exception.ResourcesNotFoundException;
import com.h87.manageUser.repository.UserSpringRepository;
import static com.h87.manageUser.utils.ManageUserErrorCode.USER_NOT_FOUND;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserSpringRepository userSpringRepository;

    @SneakyThrows

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSpringRepository
                .findByEmailAddressValue(username)
                .orElseThrow(() -> new ResourcesNotFoundException(USER_NOT_FOUND));
    }
}
