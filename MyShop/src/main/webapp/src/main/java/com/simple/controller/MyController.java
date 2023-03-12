package com.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simple.model.Employee;
import com.simple.service.EmpService;

@RestController
public class MyController {
	@Autowired
	private EmpService service;
	@GetMapping("/emp/{pageno}")
	public List<Employee> getData(@PathVariable("pageno") int pageNo)
	{
		int pagesize=3;
		List<Employee> eLi=service.findPaginated(pageNo-1, pagesize);
		return eLi;
	}

}
