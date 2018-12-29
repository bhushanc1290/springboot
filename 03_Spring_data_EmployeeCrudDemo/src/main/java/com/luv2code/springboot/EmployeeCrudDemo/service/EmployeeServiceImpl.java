package com.luv2code.springboot.EmployeeCrudDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.EmployeeCrudDemo.dao.EmployeeRepository;
import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findbyId(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);

		}
		return theEmployee;

	}

	@Override
	public void save(Employee theEmployee) {

		employeeRepository.save(theEmployee);
	}

	@Override
	public void delete(int theId) {

		employeeRepository.deleteById(theId);
	}

}
