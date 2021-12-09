package com.transaction.app.TransactionApp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.app.TransactionApp.dao.TransactionRepository;
import com.transaction.app.TransactionApp.entity.Transactions;


@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
    public EmailService emailService;
	
	@Override
	public List<Transactions> findAllTransaction() {
		return this.transactionRepo.findAll();
	}

	@Override
	public Transactions getTransactionById(Integer TId) {
		Transactions transaction = this.transactionRepo.findById(TId).get();
		return transaction;
	}

	@Override
	public Transactions addTransaction(Transactions transaction) {
		
		if(transaction!=null) {
			transaction.setTdate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			System.out.println(transaction.getTType());
			this.transactionRepo.save(transaction);
			System.out.println(transaction.getTType());
		}
		return transaction;
	}

	@Override
	public String updateTransaction(Integer TId, Transactions t) {
		Transactions transaction = this.transactionRepo.findById(TId).get();
		if(transaction!=null) {
			transaction.setTdate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			
			if(t.getAgentId()!=0) {
				transaction.setAgentId(t.getAgentId());
			}
			
			if(t.getClientId()!=0) {
				transaction.setClientId(t.getClientId());
			}
			
			if(t.getAmountOfTransaction()!=0) {
				transaction.setAmountOfTransaction(t.getAmountOfTransaction());
			}
			
			if(t.getTType()!=null) {
				transaction.setTType(t.getTType());
			}
			
			this.transactionRepo.save(transaction);
			return "Updated successfully";
		}
		return "Not exits";
	}

	@Override
	public String deleteTransaction(Integer TId) {
		Transactions transaction = this.transactionRepo.findById(TId).get();
		if(transaction!=null) {
			this.transactionRepo.delete(transaction);
			return "Deleted successfully";
		}
		return "Not exits";
	}

	@Override
	public List<Transactions> getTransactionByAgentId(Integer agentId) {
		List<Transactions> list = new ArrayList<>();
		list = this.transactionRepo.findAll();
		List<Transactions> transaction = new ArrayList<>();
		for(Transactions t:list) {
			if(t.getAgentId()==agentId) {
				transaction.add(t);
			}
		}
		
		return transaction;
	}

	@Override
	public String fundTransfer(Transactions transaction) {
		LocalDate currentDate = LocalDate.now();
		
		transaction.setTdate(currentDate.toString());
		this.transactionRepo.save(transaction);
		
		//Transactions t = this.transactionRepo.findById(transaction.getAgentId()).get();
//		if(t.getOtp()!=transaction.getOtp()) {
//			return "OTP is not match please try again";
//		}
		
		
		return "Transaction complited successfully";
	}

	@Override
	public List<Transactions> getTransactionByClientId(Integer clientId) {
		List<Transactions> list = new ArrayList<>();
		list = this.transactionRepo.findAll();
		List<Transactions> transaction = new ArrayList<>();
		for(Transactions t:list) {
			if(t.getClientId()==clientId) {
				transaction.add(t);
			}
		}
		
		return transaction;
	}
	
	public Integer generateOTP() {
		return (int) ((Math.random() * 900000) + 100000);
}

	@Override
	public String registerForFund(Transactions transaction) {
		Integer otp = generateOTP();
		emailService.sendSimpleMessage(transaction.getEmail(), "OTP for email verification" ,
				"AgentId "+transaction.getAgentId()+"\nClientId "+transaction.getClientId()+"\notp is " +otp.toString());
		transaction.setOtp(otp);
		this.transactionRepo.save(transaction);
		
		return "Otp send successfully";
	}

}
