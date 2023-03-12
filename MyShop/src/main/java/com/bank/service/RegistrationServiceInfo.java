package com.bank.service;

import com.bank.modal.Address2;
import com.bank.modal.Registration2;

public interface RegistrationServiceInfo {
	public int saveRegData(Registration2 reg2,Address2 add2);
	public Registration2 showData(int rid);
//	public void showAddress();

}
