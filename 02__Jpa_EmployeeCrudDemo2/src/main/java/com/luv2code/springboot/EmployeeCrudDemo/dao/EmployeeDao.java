package com.luv2code.springboot.EmployeeCrudDemo.dao;

import java.util.List;

import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findbyId(int theId);
	
	public void save(Employee theEmployee);
	
	public void delete(int theId);
	
}
