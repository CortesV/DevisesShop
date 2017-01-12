package com.devcortes.componets.service;

import java.util.List;

import com.devcortes.componets.entity.Client;
import com.devcortes.componets.entity.ClientRequest;

public interface IClientDao {
	public void addClient(ClientRequest clientRequest);
    public void updateClient(Long id, ClientRequest clientRequest);
    public void removeClient(Long id);    
    public List<Client> getAllClients();
}
