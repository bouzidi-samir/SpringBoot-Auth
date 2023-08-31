package com.template.authentication.authentication.repository;

import com.template.authentication.authentication.model.User;
import com.template.authentication.authentication.model.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userTest;

    @AfterEach
    void tearDown() {
        userTest.deleteAll();
    }

    // Should retrieve a user from the database according to his email.

    @Test
    void itShouldFindUserByEmail() {

        //given
        String email = "fouleck30@hotmail.fr";
        User user = User.builder()
                .email("fouleck30@hotmail.fr")
                .build();
        userTest.save(user);

        //when
        boolean expected = userTest.findByEmail(email).isPresent();

        //there
        assertTrue(expected);

    }

    // Should retrieve a user from the database according to his firstname.

    @Test
    void itShouldFindUserByFirstName() {

        //given
        String firstname = "samir";
        User user = User.builder()
                .firstname("samir")
                .build();
        userTest.save(user);

        //when
        boolean expected = userTest.findByFirstname(firstname).isPresent();

        //there
        assertTrue(expected);

    }

    // Should add a user in the database if he is valid.

    @Test
    void itShouldAddValidUser() {

        User user = User.builder()
                .firstname("John")
                .lastname("Doe")
                .email("johnDoe@hotmail.fr")
                .password("1235")
                .build();

        userTest.save(user);
        Example<User> example = Example.of(user);

        Boolean check = userTest.exists(example);
        assertTrue(check);
    }

}