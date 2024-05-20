package com.h87.manageUser.service;

import com.h87.manageUser.domain.roles.Role;
import com.h87.manageUser.domain.roles.RoleName;
import com.h87.manageUser.domain.roles.RoleRepository;
import com.h87.manageUser.repository.RoleSpringRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class DefaultRoleRepository implements RoleRepository {
    private final RoleSpringRepository roleSpringRepository;

    @Override
    public Optional<Role> findRoleByName(RoleName roleName) {
        return roleSpringRepository.findRoleByNameValue(roleName.getValue());
    }
}
