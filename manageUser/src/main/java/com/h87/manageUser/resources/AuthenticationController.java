package com.h87.manageUser.resources;

import com.h87.manageUser.service.AuthenticationService;
import com.manageUser.api.TokenApi;
import com.manageUser.model.CredentialDTO;
import com.manageUser.model.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController implements TokenApi {
    private final AuthenticationService authenticationService;

    @Override
    public ResponseEntity<TokenDTO> getAccessToken(CredentialDTO credentialDTO) {
        return null;
    }
}
