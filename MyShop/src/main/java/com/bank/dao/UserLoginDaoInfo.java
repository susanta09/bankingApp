package com.bank.dao;

import com.bank.ADto.LoginDto;
import com.bank.ADto.LoginResult;
import com.bank.modal.UserLogin;

public interface UserLoginDaoInfo {
//	public String  login(UserLogin ul);
	public int insertUserData(LoginDto cs);
	
	public LoginResult  login(LoginDto ul);
	
	

}
