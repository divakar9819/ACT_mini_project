package com.app.client.ClientApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.client.ClientApp.dao.ClientRepository;
import com.app.client.ClientApp.entity.Client;


@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepo;
	
	@Override
	public List<Client> getAllClient() {
		
		return this.clientRepo.findAll();
	}

	@Override
	public Client addClient(Client client) {
		
		return this.clientRepo.save(client);
	}

	@Override
	public Client getClientById(Integer clientId) {
		return this.clientRepo.findById(clientId).get();
	}

	@Override
	public String updateClient(Integer clientId,Client c) {
		Client client = this.clientRepo.findById(clientId).get();
		if(client!=null) {
			if(c.getClientUserName()!=null) {
				client.setClientUserName(c.getClientUserName());
			}
			
			if(c.getClientPassword()!=null) {
				client.setClientPassword(c.getClientPassword());
			}
			
			if(c.getClientState()!=null) {
				client.setClientState(c.getClientState());
			}
			
			if(c.getPhoneNumber()!=null) {
				client.setPhoneNumber(c.getPhoneNumber());
			}
			if(c.getWalletBalance()!=0) {
				client.setWalletBalance(c.getWalletBalance());
			}
			
			this.clientRepo.save(client);
			return "Updated successfully";
		}
		return "Not exits";
	}

	@Override
	public String deleteClient(Integer clientId) {
		Client client = this.clientRepo.findById(clientId).get();
		if(client!=null) {
			this.clientRepo.delete(client);
			return "Deleted successfully";
		}
		return "Not exits";
	}

	

}
