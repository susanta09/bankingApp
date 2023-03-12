package com.bank.service;

import com.bank.ADto.LoginDto;
import com.bank.ADto.LoginResult;
import com.bank.modal.UserLogin;

public interface UserLoginServiceInfo {
//	public String createAccountState(UserLogin ul);
	public int saveData(LoginDto cs);
	
	public LoginResult createAccountState(LoginDto ul);

}
