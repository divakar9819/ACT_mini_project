package com.app.client.ClientApp.service;

import java.util.List;

import com.app.client.ClientApp.entity.Client;


public interface ClientService {
	public List<Client> getAllClient();
	public Client addClient(Client client);
	public Client getClientById(Integer clientId);
	public String updateClient(Integer clientId,Client client);
	public String deleteClient(Integer clientId);

}
