package com.agent.app.AgentApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent.app.AgentApp.dao.AgentRepository;
import com.agent.app.AgentApp.entity.Agent;




@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepo;
	
	@Override
	public List<Agent> findAgent() {
		
		return this.agentRepo.findAll();
	}

	@Override
	public Agent addAgent(Agent agent) {
		return this.agentRepo.save(agent);
	}

	@Override
	public Agent getAgentById(Integer agentId) throws Exception {
		Agent agent = null;
		agent = this.agentRepo.findById(agentId).get();
		if(agent==null) {
			throw new Exception();
		}
		return agent;
	}

	@Override
	public String updateAgent(Integer agentId,Agent agent) {
		Agent a = null;

		a = this.agentRepo.findById(agentId).get();
		if(a!=null) {
			if(agent.getAccountNumber()!=null) {
				a.setAccountNumber(agent.getAccountNumber());
			}
			if(agent.getAgentName()!=null) {
				a.setAgentName(agent.getAgentName());
			}
			
			if(agent.getAgentState()!=null) {
				a.setAgentState(agent.getAgentState());
			}
			
			if(agent.getLinkBankName()!=null) {
				a.setLinkBankName(agent.getLinkBankName());
			}
			
			if(agent.getPhoneNumber()!=null) {
				a.setPhoneNumber(agent.getPhoneNumber());
			}
			
			if(agent.getWalletBalance()!=0) {
				a.setWalletBalance(agent.getWalletBalance());
			}
			
			this.agentRepo.save(a);
			return "Agent details updated successfully";
		}
		return "Agent is not exits";
	}

	@Override
	public String deleteAgent(Integer agentId) {
		Agent a = null;
		a = this.agentRepo.findById(agentId).get();
		if(a!=null) {
			this.agentRepo.delete(a);
			return "Agent details deleted successfully";
		}
		return "Agent is not exits";
	}

}
