package com.bank.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.dao.RegistrationDaoInfo;
import com.bank.modal.Address2;
import com.bank.modal.Registration2;

public class RegistrationServiceImp implements RegistrationServiceInfo {
	ApplicationContext ap = new ClassPathXmlApplicationContext("hibernate.cfg.xml");
	 RegistrationDaoInfo rdao=(RegistrationDaoInfo)ap.getBean("rdao");
	public int saveRegData(Registration2 reg2, Address2 add2) {
		int row=rdao.insertRegData(reg2,add2);
		return row;
	}
	public Registration2 showData(int rid) {
		 return rdao.getRegData(rid);
		
	}	
}
