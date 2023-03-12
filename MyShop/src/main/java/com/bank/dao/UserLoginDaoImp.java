package com.bank.dao;

import java.util.Random;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bank.ADto.LoginDto;
import com.bank.ADto.LoginResult;
import com.bank.modal.AdminLogin;
import com.bank.modal.UserLogin;

public class UserLoginDaoImp implements UserLoginDaoInfo {
	private HibernateTemplate template;
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public int insertUserData(LoginDto cs) {
		UserLogin ur=new UserLogin();
		ur.setPassword(cs.getPassword());
		ur.setEmail(cs.getEmail());
		ur.setState(cs.getState());
		ur.setUserName(cs.getUserName());
		ur.setRegNo(cs.getRegNo());
		
		System.out.println(cs);
		int i=0;
		if(cs.getUserType().equals("admin"))
		{
			AdminLogin al=new AdminLogin();
			al.setEmail(cs.getEmail());
			al.setPassword(cs.getPassword());
			al.setUserName(cs.getUserName());
			al.setUserType(cs.getUserType());
			 i=(Integer)template.save(al);
		}
		else
		{
			
			 i=(Integer)template.save(ur);
		}
		
		System.out.println("reg-dao="+i);
		return i;
	}
	 @Transactional
		public LoginResult login(LoginDto ul) {
			int password=ul.getPassword();
			String uName=ul.getUserName();
			String state="";
			LoginResult lr=new LoginResult();
			lr.setRid(0);
			lr.setUserType("null");
			lr.setState("createLoginAcount");
			String message="createLoginAcount";
			System.out.println(password+"--->"+uName);
			try {
				if(ul.getUserType().equals("admin"))
				{
					AdminLogin lu=(AdminLogin)template.get(AdminLogin.class, password);
					if(lu.getPassword()==password && uName.equals(lu.getUserName()))
					{
						//System.out.println(lu);
						lr.setUserType(lu.getUserType());
						return lr ;
					}
				}
				else {
					UserLogin lu=(UserLogin)template.get(UserLogin.class, password);
					if(lu.getPassword()==password && uName.equals(lu.getUserName()))
					{
						state=lu.getState();
						lr.setRid(lu.getRegNo());
						lr.setState(lu.getState());
						return lr ;
					}
				}
				
			} catch (Exception e) {
				e.getStackTrace();
			}
			return lr;
//		 System.out.println("Dro");
//		 System.out.println(ul);
//		 return null;
		}

}
