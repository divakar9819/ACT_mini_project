package com.agent.app.AgentApp.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
@Table(name="agent")

public class Agent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int agentId;
	private String agentName;
	private String agentState;
	private String accountNumber;
	private String phoneNumber;
	private String linkBankName;
	private int walletBalance;
	
	@Embedded
	private List<Transaction> transaction = new ArrayList<>();
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agent(int agentId, String agentName, String agentState, String accountNumber, String phoneNumber,
			String linkBankName, int walletBalance) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentState = agentState;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.linkBankName = linkBankName;
		this.walletBalance = walletBalance;
	}
	
	
	public Agent(int agentId, String agentName, String agentState, String accountNumber, String phoneNumber,
			String linkBankName, int walletBalance, List<Transaction> transaction) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentState = agentState;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.linkBankName = linkBankName;
		this.walletBalance = walletBalance;
		this.transaction = transaction;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentState() {
		return agentState;
	}
	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLinkBankName() {
		return linkBankName;
	}
	public void setLinkBankName(String linkBankName) {
		this.linkBankName = linkBankName;
	}
	public int getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}
	
	
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agentName=" + agentName + ", agentState=" + agentState
				+ ", accountNumber=" + accountNumber + ", phoneNumber=" + phoneNumber + ", linkBankName=" + linkBankName
				+ ", walletBalance=" + walletBalance + "]";
	}
	
	
	

}
