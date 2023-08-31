package com.template.authentication.authentication.controller;

import com.template.authentication.authentication.model.User;
import com.template.authentication.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getAll () {
        return userService.getAll();
    }

    @GetMapping("/findByFirstName/{firstname}")
    public ResponseEntity<User> findByFirstName (@PathVariable String firstname) {
        return userService.findByFirstName(firstname);
    }

}
