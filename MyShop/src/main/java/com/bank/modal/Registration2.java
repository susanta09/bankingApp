package com.bank.modal;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "registration")
public class Registration2 {
	@Id
	@Column(name = "rid")
	private int rid;
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;
	@Column(name = "gender")
	private String gender;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "dob")
	private String dob;
	@Column(name = "fatherName")
	private String fatherName;
	@Column(name = "email")
	private String email;
	@Column(name = "phonNo")
	private String phonNo;
	 
	@ManyToOne(targetEntity = Address3.class,cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name = "pincode"),
	    @JoinColumn(name = "city")})
	private Address3 address3;

	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonNo() {
		return phonNo;
	}
	public void setPhonNo(String phonNo) {
		this.phonNo = phonNo;
	}
	public Address3 getAddress3() {
		return address3;
	}
	public void setAddress3(Address3 add3) {
		this.address3 = add3;
	}
	@Override
	public String toString() {
		return "Registration2 [rid=" + rid + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", nationality=" + nationality + ", dob=" + dob + ", fatherName=" + fatherName + ", email=" + email
				+ ", phonNo=" + phonNo + ", address3=" + address3 + "]";
	}
	
	

	
}
