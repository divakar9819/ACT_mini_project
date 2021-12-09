package com.app.client.ClientApp.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="client")

public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int clientId;
	private String clientUserName;
	private String clientPassword;
	private int walletBalance;
	private String clientState;
	private String phoneNumber;
	
	
	@Embedded
	private List<Transaction> transaction = new ArrayList<>();
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int clientId, String clientUserName, String clientPassword, int walletBalance, String clientState,
			String phoneNumber) {
		super();
		this.clientId = clientId;
		this.clientUserName = clientUserName;
		this.clientPassword = clientPassword;
		this.walletBalance = walletBalance;
		this.clientState = clientState;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public Client(int clientId, String clientUserName, String clientPassword, int walletBalance, String clientState,
			String phoneNumber, List<Transaction> transaction) {
		super();
		this.clientId = clientId;
		this.clientUserName = clientUserName;
		this.clientPassword = clientPassword;
		this.walletBalance = walletBalance;
		this.clientState = clientState;
		this.phoneNumber = phoneNumber;
		this.transaction = transaction;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientUserName() {
		return clientUserName;
	}
	public void setClientUserName(String clientUserName) {
		this.clientUserName = clientUserName;
	}
	public String getClientPassword() {
		return clientPassword;
	}
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
	public int getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}
	public String getClientState() {
		return clientState;
	}
	public void setClientState(String clientState) {
		this.clientState = clientState;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientUserName=" + clientUserName + ", clientPassword="
				+ clientPassword + ", walletBalance=" + walletBalance + ", clientState=" + clientState
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	

}
