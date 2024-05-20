package com.h87.manageUser.resources;

import com.h87.manageUser.service.UserService;
import com.manageUser.api.UserApi;
import com.manageUser.model.RegisterUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserResources implements UserApi {
    private final UserService authenticationService;

    @Override
    public ResponseEntity<UUID> registerUser(RegisterUserDTO registerUserDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authenticationService.createUser(registerUserDTO));
    }
}
