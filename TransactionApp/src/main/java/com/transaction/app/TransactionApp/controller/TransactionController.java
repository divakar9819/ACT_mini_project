package com.transaction.app.TransactionApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.transaction.app.TransactionApp.entity.Agent;
import com.transaction.app.TransactionApp.entity.Client;
import com.transaction.app.TransactionApp.entity.Transactions;
import com.transaction.app.TransactionApp.service.TransactionService;





@RestController
@RequestMapping("transaction/api/v1")
public class TransactionController {
	
	
	@Value("${agentserver}")
	private String agentServerUrl;
	
	@Value("${clientserver}")
	private String clientServerUrl;
	
	
	@Value("${agentserverupdate}")
	private String agentUpdateUrl;
	
	
	@Value("${clientserverupdate}")
	private String clientUpdateUrl;
	
	
	@Autowired
	private TransactionService transactionService;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/thome")
	public String home() {
		return "Transaction home";
	}
	
	@GetMapping("/transaction")
	public List<Transactions> findAllTransaction(){
		return this.transactionService.findAllTransaction();
	}
	
	@GetMapping("/transaction/{TId}")
	public Transactions getTransactionById(@PathVariable Integer TId) {
		return this.transactionService.getTransactionById(TId);
	}
	
	@GetMapping("/transactionagent/{agentId}")
	public List<Transactions> getTransactionByAgentId(@PathVariable Integer agentId){
		return this.transactionService.getTransactionByAgentId(agentId);
	}
	
	@GetMapping("/transactionclient/{clientId}")
	public List<Transactions> getTransactionByClientId(@PathVariable Integer clientId){
		return this.transactionService.getTransactionByClientId(clientId);
	}
	
	
	@PostMapping("/transaction")
	public Transactions addTransaction(@RequestBody Transactions transaction) {
		return this.transactionService.addTransaction(transaction);
	}
	
	
	@PostMapping("/register")
	public String registerForFund(@RequestBody Transactions transaction) {
		System.out.println("hello");
		return this.transactionService.registerForFund(transaction);
	}
	
	
	@PostMapping("/fundTransfer")
	public String findTransfer(@RequestBody Transactions t) {
		
		Integer agentId = t.getAgentId();
		Integer clientId = t.getClientId();
		Agent agent = this.restTemplate.getForObject(agentServerUrl+agentId, Agent.class);
		Client client = this.restTemplate.getForObject(clientServerUrl+clientId, Client.class);
		if(agent==null) {
			return "Agnet of this id is not exits";
		}
		
		if(client==null) {
			return "Client of this id is not exits";
		}
		
		if(t.getTType().equals("AToC")) {
			if(agent.getWalletBalance()-t.getAmountOfTransaction()<5000) {
				return "Sorry!! Agent does not have sufficient balanace";
			}
			else {
				agent.setWalletBalance(agent.getWalletBalance()-t.getAmountOfTransaction());
				client.setWalletBalance(client.getWalletBalance()+t.getAmountOfTransaction());
				
			}
			
			
		}  //end AToC
		
		else if(t.getTType().equals("CToA")) {
			if(client.getWalletBalance()-t.getAmountOfTransaction()<4000) {
				return "Sorry!! Agent does not have sufficient balanace";
			}
			else {
				agent.setWalletBalance(agent.getWalletBalance() + t.getAmountOfTransaction());
				client.setWalletBalance(client.getWalletBalance() - t.getAmountOfTransaction());
				
			}
		}
		

		//updating agent details
		this.restTemplate.put(agentUpdateUrl+agentId, agent);
		
		//updating client details
		this.restTemplate.put(clientUpdateUrl+clientId, client);
		
		this.transactionService.fundTransfer(t);
		return "Fund Transfer completed successfully";
	}
	
	
	@PutMapping("/transaction/{TId}")
	public String updateTransaction(@PathVariable Integer TId,@RequestBody Transactions transaction) {
		return this.transactionService.updateTransaction(TId, transaction);
	}
	
	@DeleteMapping("/transaction/{TId}")
	public String deleteTransaction(@PathVariable Integer TId) {
		return this.transactionService.deleteTransaction(TId);
	}

}
