package com.ms.user.data.usecases.email;

import com.ms.user.core.dtos.EmailDto;
import com.ms.user.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user) {
        EmailDto emailDto = new EmailDto();

        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso");
        emailDto.setText(user.getName() + ", seja bem-vindo! \nAgradecemos o seu cadastro, aproveite o nosso site e Viva Cristo Rei");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
