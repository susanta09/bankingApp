package com.simple.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simple.model.Employee;
import com.simple.repo.EmpRepository;
@Service
public class EmpService implements EmpServiceInfo {
	@Autowired
	private EmpRepository repo;

	@Override
	public List<Employee> findPaginated(int pageNo, int pageSize) {
		
		List<Employee> eli=new ArrayList<Employee>();
		Pageable paging=PageRequest.of(pageNo, pageSize);
		Page<Employee> pageResult=repo.findAll(paging);
		
		System.out.println("Tota Element----> "+pageResult.getTotalElements());
		System.out.println("Tota Pages------> "+pageResult.getTotalPages());
		System.out.println("Current Page no--> "+pageResult.getNumber());
		System.out.println("No of Element in a page-->"+pageResult.getNumberOfElements());
		
		if(pageResult.hasContent())
		{
		   eli=pageResult.getContent();	
		   return pageResult.getContent();
		}else {
			return eli;
		}
		
	}


}
