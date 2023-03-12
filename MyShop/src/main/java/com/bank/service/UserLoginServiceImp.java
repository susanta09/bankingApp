package com.bank.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.ADto.LoginDto;
import com.bank.ADto.LoginResult;
import com.bank.dao.UserLoginDaoImp;
import com.bank.dao.UserLoginDaoInfo;
import com.bank.modal.UserLogin;

public class UserLoginServiceImp implements UserLoginServiceInfo {
	 ApplicationContext ap=new ClassPathXmlApplicationContext("hibernate.cfg.xml");
	 UserLoginDaoInfo dao=(UserLoginDaoInfo)ap.getBean("dao");	


	 public int saveData(LoginDto cs) {
			int i=dao.insertUserData(cs);
			return i;
		}
//	public String createAccountState(UserLogin ul) {
//		
//		return dao.login(ul);
//	}


	public LoginResult createAccountState(LoginDto ul) {
		
		 return dao.login(ul);
	}


}
