package com.bank.dao;

import com.bank.modal.Address2;
import com.bank.modal.Registration2;

public interface RegistrationDaoInfo {
	public int insertRegData(Registration2 reg2,Address2 add2);
	public Registration2 getRegData(int rid);
//	public Address2 getAddress();
}
