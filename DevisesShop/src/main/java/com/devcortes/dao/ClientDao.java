package com.devcortes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcortes.entity.Client;
import com.devcortes.entity.ClientRequest;
import com.devcortes.repository.IClientRepository;

@Service
public class ClientDao implements IClientDao{
	@Autowired
	private IClientRepository clientRepository;	
	/**
	 * Add new client
	 * @param clientRequest
	 */
	@Override
	public void addClient(ClientRequest clientRequest) {
		Client client = new Client(clientRequest.getName(), clientRequest.getGender(), clientRequest.getAge());		
		clientRepository.save(client);		
	}
	/**
	 * Update information about client
	 * @param id
	 * @param clientRequest
	 */
	@Override
	public void updateClient(Long id, ClientRequest clientRequest) {
		clientRepository.findOne(id).setName(clientRequest.getName());
		clientRepository.findOne(id).setGender(clientRequest.getGender());
		clientRepository.findOne(id).setAge(clientRequest.getAge());
		clientRepository.save(clientRepository.findOne(id));				
	}
	/**
	 * Delete client
	 * @param id
	 */
	@Override
	public void removeClient(Long id) {
		clientRepository.delete(id);
		
	}
	/**
	 * Get information about all clients
	 * @return
	 */
	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();		
	}
}