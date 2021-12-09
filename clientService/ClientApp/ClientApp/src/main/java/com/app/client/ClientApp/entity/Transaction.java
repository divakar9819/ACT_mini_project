package com.app.client.ClientApp.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Transaction {
	
	private int TId;
	private String Tdate;
	private int agentId;
	private int amountOfTransaction;
	private String TType;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int tId, String tdate, int agentId, int amountOfTransaction, String tType) {
		super();
		TId = tId;
		Tdate = tdate;
		this.agentId = agentId;
		this.amountOfTransaction = amountOfTransaction;
		TType = tType;
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
	@Override
	public String toString() {
		return "Transaction [TId=" + TId + ", Tdate=" + Tdate + ", agentId=" + agentId + ", amountOfTransaction="
				+ amountOfTransaction + ", TType=" + TType + "]";
	}
	
	

}
