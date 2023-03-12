package com.bank.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.ADto.TransactionDto;
import com.bank.dao.AccountDaoInfo;
import com.bank.modal.Account;
import com.bank.modal.PaymentDetails;
import com.bank.modal.TransactionDetails;


public class AccountServiceImpl implements AccountServiceInfo {
	ApplicationContext context =new ClassPathXmlApplicationContext("hibernate.cfg.xml");
	AccountDaoInfo bi=(AccountDaoInfo)context.getBean("acdao");
	public int depositAccount(TransactionDto dto) {
		
		return bi.creditAccount(dto);
	}
	public int withdrawAccount(TransactionDto dto) {
		
		return bi.debitAccount(dto);
	}

	public int firstData(int rid) {
		return bi.first(rid);
		
	}
	public List<TransactionDetails> tranHisDet(int rid,int currentP,int item) {
		return bi.getTDetails(rid,currentP,item);
		
	}
	public int transactionPay(TransactionDto tdo) {
		return bi.payAccount(tdo);
		
	}
	public int firstPaymentData(int rid) {
		return bi.firstPayment(rid);
		
	}
	public List<PaymentDetails> paymenDetails(int rid,int currentP,int item) {
		return bi.getPayDetails(rid,currentP, item);
	}
	//====admin section===========
    public Account searchAccount(int rid) {
		
		return bi.getAccDetails(rid);
	}
	public Account updateAccount(Account account) {
		return bi.updateAcc(account);
	}
	public int saveAccount(Account ac) {
		
		return bi.createAccount(ac);
	}

	

}
