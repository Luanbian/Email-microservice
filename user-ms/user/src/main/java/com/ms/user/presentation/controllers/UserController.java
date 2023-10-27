package com.ms.user.presentation.controllers;

import com.ms.user.core.dtos.UserDto;
import com.ms.user.data.usecases.CreateUser;
import com.ms.user.data.usecases.SendGreetingUser;
import com.ms.user.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private CreateUser createUser;

    @Autowired
    private SendGreetingUser sendGreetingUser;

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody @Valid UserDto data) {
        User newUser = createUser.perform(data);
        sendGreetingUser.perform(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
