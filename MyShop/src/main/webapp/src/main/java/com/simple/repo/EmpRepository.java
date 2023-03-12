package com.simple.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.model.Employee;
public interface EmpRepository extends JpaRepository<Employee, Integer> {


}
