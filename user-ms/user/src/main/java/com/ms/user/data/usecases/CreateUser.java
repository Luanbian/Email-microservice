package com.ms.user.data.usecases;

import com.ms.user.core.dtos.UserDto;
import com.ms.user.infra.repositories.UserRepository;
import com.ms.user.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {
    @Autowired
    private UserRepository repository;
    @Transactional
    public User perform(UserDto data) {
        User newUser = new User();
        newUser.setName(data.name());
        newUser.setEmail(data.email());
        repository.save(newUser);
        return newUser;
    }
}
