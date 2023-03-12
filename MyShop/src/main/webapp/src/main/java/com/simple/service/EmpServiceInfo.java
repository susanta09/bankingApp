package com.simple.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.simple.model.Employee;

public interface EmpServiceInfo {
	List<Employee> findPaginated(int pageNo,int pageSize);

}
