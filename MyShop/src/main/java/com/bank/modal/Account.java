package com.bank.modal;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "account")
public class Account {
	@Id
	private int rid;
	private int accountNo;
	private String accountType;
	private int totalAmount;
	private LocalDateTime date;
	private String access;
	

	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public Account() {
		super();
	}
	public Account(int accountNo, String accountType, int totalAmount, LocalDateTime date, String access, int rid) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.totalAmount = totalAmount;
		this.date = date;
		this.access = access;
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", totalAmount=" + totalAmount
				+ ", date=" + date + ", access=" + access + ", rid=" + rid + "]";
	}


	

}
