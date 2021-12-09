package com.transaction.app.TransactionApp.service;

import java.util.List;

import com.transaction.app.TransactionApp.entity.Transactions;


public interface TransactionService {
	
	public List<Transactions> findAllTransaction();
	public Transactions getTransactionById(Integer TId);
	public Transactions addTransaction(Transactions transaction);
	public String updateTransaction(Integer TId,Transactions transaction);
	public String deleteTransaction(Integer TId );
	
	public List<Transactions> getTransactionByAgentId(Integer userId);
	
	public List<Transactions> getTransactionByClientId(Integer clientId);
	
	public String registerForFund(Transactions transaction);
	
	public String  fundTransfer(Transactions transaction);

}
