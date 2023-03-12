package com.bank.dao;

import java.util.List;

import com.bank.ADto.TransactionDto;
import com.bank.modal.Account;
import com.bank.modal.PaymentDetails;
import com.bank.modal.TransactionDetails;



public interface AccountDaoInfo {
	public int creditAccount(TransactionDto dto);
	public int debitAccount(TransactionDto dto);
	public void transferAccount(TransactionDto dto);
	public int first(int rid);
	public List<TransactionDetails> getTDetails(int rid,int currentP,int item);
	
	public int payAccount(TransactionDto dto);
	 public void insertPaymentDetails(TransactionDto tdo);
	 public int firstPayment(int rid);
	 public List<PaymentDetails> getPayDetails(int rid,int currentP,int item);
//====admin=======
	 public Account getAccDetails(int rid);
	 public Account updateAcc(Account account);
		public int createAccount(Account ac);
}
