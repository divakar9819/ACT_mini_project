package com.agent.app.AgentApp.services;

import java.util.List;

import com.agent.app.AgentApp.entity.Agent;



public interface AgentService {
	public List<Agent> findAgent();
	public Agent addAgent(Agent agent);
	public Agent getAgentById(Integer agentId) throws Exception;
	public String updateAgent(Integer agentId,Agent agent);
	public String deleteAgent(Integer agentId);

}
