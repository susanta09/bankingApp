package com.bank.service;

import java.util.List;

import com.bank.ADto.TransactionDto;
import com.bank.modal.Account;
import com.bank.modal.PaymentDetails;
import com.bank.modal.TransactionDetails;



public interface AccountServiceInfo {
	public int depositAccount(TransactionDto dto);
	public int withdrawAccount(TransactionDto dto);
	//public void transactionData(TransactionDto dto);
	public int firstData(int rid);
	public List<TransactionDetails> tranHisDet(int rid,int currentP,int item);
	 public int transactionPay(TransactionDto tdo);
	 public int firstPaymentData(int rid);
	 public List<PaymentDetails> paymenDetails(int rid,int currentP,int item);
//====admin section==========
	 public Account searchAccount(int rid);
	 public Account updateAccount(Account account);
	 public int saveAccount(Account ac);
}
