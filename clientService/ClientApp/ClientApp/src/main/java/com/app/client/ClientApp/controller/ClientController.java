package com.app.client.ClientApp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.client.ClientApp.entity.Client;
import com.app.client.ClientApp.service.ClientService;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("client/api/v1")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Auto
	private RestTemplate restTemplate;
	
	
	@GetMapping("/chome")
	public String home() {
		return "client home";
	}
	
	@GetMapping("/client")
	public List<Client> getAllClient(){
		return this.clientService.getAllClient();
	}
	
	
	@GetMapping("/client/{clientId}")
	public Client getClientById(@PathVariable Integer clientId) {
		 Client client =  this.clientService.getClientById(clientId);
		 //List transaction = this.restTemplate.getForObject("http://transaction-server/transaction/api/v1/transactionclient/"+clientId, List.class);
		 //client.setTransaction(transaction);
		 return client;
	}
	
	
	@PostMapping("/client")
	public Client addClient(@RequestBody Client client) {
		return this.clientService.addClient(client);
		
	}
	
	@PutMapping("/updateClient/{clientId}")
	public String updateClient(@PathVariable Integer clientId,@RequestBody Client client) {
		return this.clientService.updateClient(clientId, client);
	}
	
	@DeleteMapping("/client/{clientId}")
	public String deleteClient(@PathVariable Integer clientId) {
		return this.clientService.deleteClient(clientId);
	}

}
