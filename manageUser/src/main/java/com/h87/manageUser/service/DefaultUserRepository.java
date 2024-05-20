package com.h87.manageUser.service;

import com.h87.manageUser.domain.users.UserRepository;
import com.h87.manageUser.repository.UserSpringRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserRepository implements UserRepository {
    private final UserSpringRepository userSpringRepository;
}
