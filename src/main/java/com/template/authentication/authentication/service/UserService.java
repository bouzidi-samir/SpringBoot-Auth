package com.template.authentication.authentication.service;

import com.template.authentication.authentication.model.User;
import com.template.authentication.authentication.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public ResponseEntity<List<User>> getAll () {

        return new ResponseEntity<>(
                userRepository.findAll(),
                HttpStatus.OK
                );
    }

    public ResponseEntity<User> findByFirstName(String firstname) {

        Optional<User> userOptional = userRepository.findByFirstname(firstname);

        return userOptional
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
