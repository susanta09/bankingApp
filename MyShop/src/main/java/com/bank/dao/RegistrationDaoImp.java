package com.bank.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bank.modal.Address2;
import com.bank.modal.Address3;
import com.bank.modal.AddressId;
import com.bank.modal.Registration2;

public class RegistrationDaoImp implements RegistrationDaoInfo {
	private HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public int insertRegData(Registration2 reg2, Address2 add2) {
		
		AddressId id=new AddressId();
		id.setPincode(add2.getPincode());
		id.setCity(add2.getCity());
		
		Address3 add3=new Address3();
		add3.setId(id);
		add3.setDist(add2.getDist());
		add3.setState(add2.getState());
		add3.setCountry(add2.getCountry());
		
		reg2.setAddress3(add3);
		
		System.out.println("dao-->");
		int row = (Integer) template.save(reg2);
		return row;
	}

	@Transactional
	public Registration2  getRegData(int rid) {
		Registration2 reg=(Registration2)template.get(Registration2.class, rid);
		System.out.println(reg.getFname());
		System.out.println(reg.getLname());
		//System.out.println(reg.getAddress());
		Address3 add3 =(Address3)reg.getAddress3();
		System.out.println(add3.getId());
		System.out.println(add3.getId().getPincode());
		System.out.println(add3.getId().getCity());
		System.out.println(add3.getDist());
		System.out.println(add3.getState());
		System.out.println(add3.getCountry());
		Address2 add2=new Address2();
		add2.setPincode(add3.getId().getPincode());
		add2.setCity(add3.getId().getCity());
		add2.setDist(add3.getDist());
		add2.setState(add3.getState());
		add2.setCountry(add3.getCountry());
		System.out.println(reg);
		System.out.println("reg2="+rid);
		return reg;
		
//		return null;
		
	}
//	@Transactional
//	public Address2 getAddress()
//	{
//		AddressId id=new AddressId(765456, "xyz");
//		AddressId id1=new AddressId(765456, "xyza");
//		Address3 add3=(Address3)template.get(Address3.class, id);
////		Address2 add2=(Address2)add3.getId();
//		
//		Address2 add2=new Address2();
//		add2.setPincode(add3.getId().getPincode());
//		add2.setCity(add3.getId().getCity());
//		add2.setDist(add3.getDist());
//		add2.setState(add3.getState());
//		add2.setCountry(add3.getCountry());
//		
//		System.out.println(add3.getId().getPincode());
//		System.out.println(add3.getId().getCity());
////		System.out.println(id.equals(add3.getId()));
////		System.out.println("--------------");
////		System.out.println(id1.equals(add3.getId()));
//	}

	
}
