package com.mardeveloper.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mardeveloper.cadastro.dto.ClientOrderDto;
import com.mardeveloper.cadastro.dto.LoginDto;
import com.mardeveloper.cadastro.entity.Client;
import com.mardeveloper.cadastro.message.ClientSendMessage;
import com.mardeveloper.cadastro.message.LoginSendMessage;
import com.mardeveloper.cadastro.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientSendMessage clientSendMessage;
	
	@Autowired
	private LoginSendMessage loginSendMessage;	
	
	public Client insertClient(Client client) {
		Client newClient = clientRepository.save(client);
		
		clientSendMessage.sendMessage(ClientOrderDto.create(newClient));
		
		loginSendMessage.sendMessage(LoginDto.create(newClient));
		
		return newClient;
	}
	
	public Client updateClient (Client client) {
		
		Optional<Client> objClient = clientRepository.findById(client.getId());
		
		if (objClient.isPresent()) {
			return clientRepository.save(client);			
		} else {
			return null; 			
		}
	}
	
	public boolean deleteCliente(Long id) {
		
		Optional<Client> objClient = clientRepository.findById(id);
		
		if (objClient.isPresent()) {
			clientRepository.delete(objClient.get());
			return true;
		} else {
			return false; 			
		}
	}
	
	public Optional<Client> findById(Long id) {
		
		Optional<Client> objClient = clientRepository.findById(id);
		
		return objClient;
	}
	
	public List<Client> findAll() {
		
		List<Client> list = clientRepository.findAll();
		
		return list;
	}	

}
