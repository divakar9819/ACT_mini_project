package com.transaction.app.TransactionApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int TId;
	private String Tdate;
	private int agentId;
	private int clientId;
	private int amountOfTransaction;
	private String TType;
	private String email;
	private int otp;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int tId, String tdate, int agentId, int clientId, int amountOfTransaction, String tType,String email,int otp) {
		super();
		TId = tId;
		Tdate = tdate;
		this.agentId = agentId;
		this.clientId = clientId;
		this.amountOfTransaction = amountOfTransaction;
		this.TType = tType;
		this.email  = email;
		this.otp = otp;
	}
	public int getTId() {
		return TId;
	}
	public void setTId(int tId) {
		TId = tId;
	}
	public String getTdate() {
		return Tdate;
	}
	public void setTdate(String tdate) {
		Tdate = tdate;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getAmountOfTransaction() {
		return amountOfTransaction;
	}
	public void setAmountOfTransaction(int amountOfTransaction) {
		this.amountOfTransaction = amountOfTransaction;
	}
	public String getTType() {
		return TType;
	}
	public void setTType(String tType) {
		TType = tType;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Transactions [TId=" + TId + ", Tdate=" + Tdate + ", agentId=" + agentId + ", clientId=" + clientId
				+ ", amountOfTransaction=" + amountOfTransaction + ", TType=" + TType + "]";
	}
	
	
	
	

}
