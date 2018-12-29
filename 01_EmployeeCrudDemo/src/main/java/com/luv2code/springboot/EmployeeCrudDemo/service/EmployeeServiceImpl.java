package com.luv2code.springboot.EmployeeCrudDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.EmployeeCrudDemo.dao.EmployeeDao;
import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findbyId(int theId) {
		return employeeDao.findbyId(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {

		employeeDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void delete(int theId) {

		employeeDao.delete(theId);
	}

}
