package com.devcortes.dao;

import java.util.List;

import com.devcortes.entity.Client;
import com.devcortes.entity.ClientRequest;

public interface IClientDao {
	public void addClient(ClientRequest clientRequest);
    public void updateClient(Long id, ClientRequest clientRequest);
    public void removeClient(Long id);    
    public List<Client> getAllClients();
}
