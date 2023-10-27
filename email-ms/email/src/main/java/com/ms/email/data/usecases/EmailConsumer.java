package com.ms.email.data.usecases;

import com.ms.email.core.dtos.EmailDto;
import com.ms.email.models.Email;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private SaveEmail saveEmail;
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        Email sendingStatus = sendEmail.perform(email);
        saveEmail.perform(sendingStatus);
    }
}
