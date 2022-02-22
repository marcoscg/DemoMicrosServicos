package com.mardeveloper.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mardeveloper.login.entity.Login;
import com.mardeveloper.login.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	

	public Login save(Login client) {	
		PasswordEncoder bcryptEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		Login newLogin = new Login();
		newLogin.setUsername(client.getUsername());
		newLogin.setPassword(bcryptEncoder.encode(client.getPassword()).replace("{bcrypt}", ""));
		
		return loginRepository.save(newLogin);
	}	

}
