package com.ms.email.data.usecases;

import com.ms.email.infra.repositories.EmailRepository;
import com.ms.email.models.Email;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveEmail {
    @Autowired
    private EmailRepository repository;

    public void perform (Email email) {
        repository.save(email);
    }
}
