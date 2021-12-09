package com.agent.app.AgentApp.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.agent.app.AgentApp.entity.Agent;
import com.agent.app.AgentApp.services.AgentService;



@RestController
@RequestMapping("api/v1")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/agent")
	public List<Agent> findAgent(){
		return this.agentService.findAgent();
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
//	@GetMapping("agent/{agentId})")
//	public Agent getAgentById(@PathVariable String agentId) {
//		return this.agentService.getAgentById(Integer.parseInt(agentId));
//	}
	
	@GetMapping("/agent/{agentId}")
	public Agent getAgentById(@PathVariable Integer agentId) throws Exception {
		Agent agent =  this.agentService.getAgentById(agentId);
		
		List transaction = this.restTemplate.getForObject("http://transaction-server/transaction/api/v1/transactionagent/"+agentId, List.class);
		agent.setTransaction(transaction);
		return agent;
	}
	
	@PostMapping("/agent")
	public Agent addAgent( @RequestBody Agent agent) {
		System.out.println("working");
		return this.agentService.addAgent(agent);
	}
	
	@PutMapping("/updateagent/{agentId}")
	public String updateAgent(@PathVariable Integer agentId,@RequestBody Agent agent) {
		this.agentService.updateAgent(agentId, agent);
		return "Agent details updated successfully";
	}
	
	@DeleteMapping("/agent/{agentId}")
	public String deleteAgent(@PathVariable Integer agentId) {
		this.agentService.deleteAgent(agentId);
		return "Agent deleted successfully";
	}

}
