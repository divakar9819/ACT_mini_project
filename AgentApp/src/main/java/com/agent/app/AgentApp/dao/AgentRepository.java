package com.agent.app.AgentApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agent.app.AgentApp.entity.Agent;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
