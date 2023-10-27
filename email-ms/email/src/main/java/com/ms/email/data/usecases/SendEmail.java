package com.ms.email.data.usecases;

import com.ms.email.models.Email;
import com.ms.email.models.StatusEmail;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDateTime;

public class SendEmail {
    @Autowired
    private JavaMailSender mailSender;

    @Value(value = "${spring.mail.username}")
    private String from;
    @Transactional
    public Email perform (Email email) {
        try {
            email.setSendDateTime(LocalDateTime.now());
            email.setEmailFrom(from);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            mailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException error) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return email;
        }
    }
}
