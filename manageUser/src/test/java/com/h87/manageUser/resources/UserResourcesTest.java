package com.h87.manageUser.resources;

import com.h87.manageUser.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = {UserResources.class})
class UserResourcesTest {
    @MockBean
    private UserService userService;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void registerUserTest() {
    }
}