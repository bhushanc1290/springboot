package com.luv2code.springboot.EmployeeCrudDemo.service;

import java.util.List;

import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findbyId(int theId);

	public void save(Employee theEmployee);

	public void delete(int theId);
}
