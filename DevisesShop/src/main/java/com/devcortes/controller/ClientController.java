package com.devcortes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devcortes.componets.entity.Client;
import com.devcortes.componets.entity.ClientRequest;
import com.devcortes.service.ClientService;
/**
 * Controller for entity Client contain GET, POST, PUT, DELETE methods
 * @author cortes
 *
 */
@RestController
@RequestMapping(value="/client")
public class ClientController {	
	@Autowired	
	private ClientService clientService;	
	/**
	 * Get information about all clients
	 * @return
	 */
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Client> getAllClients(){			
		return clientService.getAllClients();
	} 	
	/**
	 * Add new client
	 * @param clientRequest
	 */
	@RequestMapping(value="/addClient", method = RequestMethod.POST)
	public void addClient(@RequestBody ClientRequest clientRequest){
		clientService.addClient(clientRequest);
	}
	/**
	 * Delete client
	 * @param id
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public void deleteClient(@PathVariable("id") Long id){
		clientService.removeClient(id);
	}
	/**
	 * Update information about client
	 * @param id
	 * @param clientRequest
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public void putUser(@PathVariable("id") Long id, @RequestBody ClientRequest clientRequest){		
		clientService.updateClient(id, clientRequest);
	}
}

