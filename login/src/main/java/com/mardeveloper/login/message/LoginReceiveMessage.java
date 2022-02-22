package com.mardeveloper.login.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.mardeveloper.login.dto.ClientDto;
import com.mardeveloper.login.entity.Login;
import com.mardeveloper.login.service.LoginService;

@Component
public class LoginReceiveMessage {

    private final LoginService loginService;

    @Autowired
    public LoginReceiveMessage(LoginService loginService) {
        this.loginService = loginService;
    }

    @RabbitListener(queues = {"${cadastro.login.rabbitmq.queue}"})
    public void receive(@Payload ClientDto clientDto) {
        System.out.println(clientDto);
        
		Login login = new Login();
		login.setUsername(clientDto.getEmail());
		login.setPassword(clientDto.getPassword());
        
		loginService.save(login);
    }

}
