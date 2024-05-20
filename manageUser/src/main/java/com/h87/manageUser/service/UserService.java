package com.h87.manageUser.service;

import com.h87.manageUser.domain.commons.EntityBase;
import com.h87.manageUser.domain.roles.RoleRepository;
import com.h87.manageUser.domain.users.User;
import com.h87.manageUser.domain.users.UserRepository;
import com.h87.manageUser.exception.InternalServerError;
import com.h87.manageUser.service.mapper.UserMapper;
import com.h87.manageUser.utils.ManageUserErrorCode;
import com.h87.manageUser.utils.RegisterUserData;
import com.manageUser.model.RegisterUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @SneakyThrows
    @Transactional
    public UUID createUser(RegisterUserDTO registerUserDTO) {
        RegisterUserData registerUserData = userMapper.fromRegisterUserDTOToRegisterUserData(registerUserDTO);
        User createdUser = User.createUser(
                registerUserData,
                passwordEncoder,
                roleRepository,
                userRepository
        );
        return Optional.ofNullable(createdUser)
                .map(EntityBase::getId)
                .orElseThrow(() -> new InternalServerError(ManageUserErrorCode.INTERNAL_SERVER_ERROR));
    }
}
