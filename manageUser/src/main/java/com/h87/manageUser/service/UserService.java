package com.h87.manageUser.service;

import com.h87.manageUser.domain.EmailTemplateName;
import com.h87.manageUser.domain.roles.RoleRepository;
import com.h87.manageUser.domain.tokens.Token;
import com.h87.manageUser.domain.tokens.TokenRepository;
import com.h87.manageUser.domain.users.RoleNotFoundException;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Integer activationCodeLength;
    private final String activationCodeCharacters;
    private final Integer activationCodeExpirationMinutes;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    @Value("${application.mailing.frontend.activate-url}")
    private String activationUrl;


    @SneakyThrows
    @Transactional
    public UUID createUser(RegisterUserDTO registerUserDTO) {
        RegisterUserData registerUserData = userMapper.fromRegisterUserDTOToRegisterUserData(registerUserDTO);
        User createdUser;
        try {
            createdUser = User.createUser(
                    registerUserData,
                    passwordEncoder,
                    roleRepository,
                    userRepository
            );
        } catch (RoleNotFoundException e) {
            throw new InternalServerError(ManageUserErrorCode.ROLE_NOT_FOUND);
        }
        String activationCode = User.generateActivationCode(activationCodeLength, activationCodeCharacters);
        Token generatedToken = createdUser.generatedToken(activationCode, activationCodeExpirationMinutes, tokenRepository);
        sendValidationEmail(createdUser, generatedToken);
        return createdUser.getId();
    }

    @SneakyThrows
    private void sendValidationEmail(User createdUser, Token token) {
        emailService.sendEmail(
                createdUser.getEmailAddress().getValue(),
                createdUser.getFullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                token.getValue().getToken(),
                "Account Activation"
        );
    }
}
