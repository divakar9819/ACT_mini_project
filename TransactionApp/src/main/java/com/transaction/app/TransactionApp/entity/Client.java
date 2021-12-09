package com.transaction.app.TransactionApp.entity;

import java.util.HashSet;

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


public class Client {
	
	private String clientUserName;
	private String clientPassword;
	private int walletBalance;
	private String clientState;
	private String phoneNumber;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String clientUserName, String clientPassword, int walletBalance, String clientState,
			String phoneNumber) {
		super();
		
		this.clientUserName = clientUserName;
		this.clientPassword = clientPassword;
		this.walletBalance = walletBalance;
		this.clientState = clientState;
		this.phoneNumber = phoneNumber;
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
	@Override
	public String toString() {
		return "Client [clientUserName=" + clientUserName + ", clientPassword=" + clientPassword + ", walletBalance="
				+ walletBalance + ", clientState=" + clientState + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
	
	

}
