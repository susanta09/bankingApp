package com.bank.ADto;



public class LoginDto {
	private int password;
	private int regNo;
	private String userName;
	private String state;
    private String email;
    private String userType;
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "LoginDto [password=" + password + ", regNo=" + regNo + ", userName=" + userName + ", state=" + state
				+ ", email=" + email + ", userType=" + userType + "]";
	}

}
