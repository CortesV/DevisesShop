package com.devcortes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcortes.componets.entity.Client;
import com.devcortes.componets.entity.ClientRequest;
import com.devcortes.componets.service.IClientDao;
/**
 * Service for entity Client contain methods for add, remove, update, get clients
 * @author cortes
 *
 */
@Service
public class ClientService{
	
	@Autowired	
	private IClientDao clientDao;
	
	
	public IClientDao getClientDao() {
		return clientDao;
	}
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
	/**
	 * Add new client
	 * @param clientRequest
	 */
	public void addClient(ClientRequest clientRequest) {
		clientDao.addClient(clientRequest);	
	}
	/**
	 * Update information about client
	 * @param id
	 * @param clientRequest
	 */
	public void updateClient(Long id, ClientRequest clientRequest) {
		clientDao.updateClient(id, clientRequest);		
	}
	/**
	 * Delete client
	 * @param id
	 */
	public void removeClient(Long id) {
		clientDao.removeClient(id);
		
	}
	/**
	 * Get information about all clients
	 * @return
	 */
	public List<Client> getAllClients() {		
		return clientDao.getAllClients();
	}	

}
