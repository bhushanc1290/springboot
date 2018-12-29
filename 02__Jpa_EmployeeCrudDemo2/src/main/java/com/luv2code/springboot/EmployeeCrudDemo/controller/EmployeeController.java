package com.luv2code.springboot.EmployeeCrudDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;
import com.luv2code.springboot.EmployeeCrudDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeId}")
	public Employee getEmployee(@PathVariable int employeId) {
		// get the employee
		Employee tempEmployee = employeeService.findbyId(employeId);

		if (tempEmployee == null) {
			throw new RuntimeException("Employee with id: " + employeId + " not found");
		}
		return tempEmployee;

	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee thEmployee) {

		thEmployee.setId(0);

		employeeService.save(thEmployee);
		
		return thEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee thEmployee) {

		employeeService.save(thEmployee);
		
		return thEmployee;
	}

	@DeleteMapping("/employees/{employeId}")
	public String updateEmployee(@PathVariable int employeId) {

		// get the employee
		Employee tempEmployee = employeeService.findbyId(employeId);

		if (tempEmployee == null) {
			throw new RuntimeException("Employee with id: " + employeId + " not found");
		}
		
		employeeService.delete(employeId);
		return "Deleted Employee id -" +employeId;
	}

}
