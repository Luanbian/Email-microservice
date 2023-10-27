package com.ms.user.data.usecases;

import com.ms.user.data.usecases.email.EmailProducer;
import com.ms.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendGreetingUser {
    @Autowired
    private EmailProducer emailProducer;

    public void perform (User newUser) {
        emailProducer.publishMessageEmail(newUser);
    }
}
