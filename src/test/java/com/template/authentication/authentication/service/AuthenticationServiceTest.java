package com.template.authentication.authentication.service;

import com.template.authentication.authentication.model.RegisterRequest;
import com.template.authentication.authentication.model.Role;
import com.template.authentication.authentication.model.User;
import com.template.authentication.authentication.model.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @Mock
    UserRepository userRep;

    private AuthenticationService authenticationServ;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setup() {
        this.authenticationServ = new AuthenticationService(
                userRep,
                passwordEncoder,
                jwtService,
                authenticationManager);
    }

    // Should save a user in the database.

    @Test
    void register() {

        User user =  User.builder()
                .firstname("John")
                .lastname("Doe")
                .email("johnDoe@hotmail.fr")
                .password(null)
                .role(Role.USER)
                .build();

        RegisterRequest body = new RegisterRequest(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword()
        );

        authenticationServ.register(body);

        verify(userRep).save(user);
    }

    @Test
    void authenticate() {
    }
}