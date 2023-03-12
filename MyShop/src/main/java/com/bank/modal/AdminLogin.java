package com.bank.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "adminLogin")
public class AdminLogin {
	@Id
	private int password;
	private String userName;
    private String email;
    private String userType;
   
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AdminLogin [password=" + password + ", userName=" + userName + ", email=" + email + ", userType="
				+ userType + "]";
	}
    

}
