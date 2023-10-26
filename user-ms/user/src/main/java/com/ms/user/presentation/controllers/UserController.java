package com.ms.user.presentation.controllers;

import com.ms.user.core.dtos.UserDto;
import com.ms.user.models.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody @Valid UserDto data) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
