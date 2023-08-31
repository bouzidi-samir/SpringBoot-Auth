package com.template.authentication.authentication.service;

import com.template.authentication.authentication.model.User;
import com.template.authentication.authentication.model.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void shouldGetAll() {

        userService.getAll();

        verify(userRepository).findAll();
    }

    @Test
    void shouldGetByFirstName() {

        String firstname = "samir";

        userService.findByFirstName(firstname);

        verify(userRepository).findByFirstname(firstname);

    }

}