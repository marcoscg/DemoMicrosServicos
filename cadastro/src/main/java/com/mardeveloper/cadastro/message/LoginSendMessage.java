package com.mardeveloper.cadastro.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mardeveloper.cadastro.dto.LoginDto;

@Component
public class LoginSendMessage {

    @Value("${cadastro.rabbitmq.exchange}")
    String exchange;

    @Value("${cadastro.login.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public void sendMessage(LoginDto login) {
        System.out.println(login);
        System.out.println(exchange);
        System.out.println(routingkey);
        rabbitTemplate.convertAndSend(exchange, routingkey, login);
    }

}