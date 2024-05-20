package com.h87.manageUser.domain.roles;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findRoleByName(RoleName user);
}
