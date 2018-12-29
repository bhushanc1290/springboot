package com.luv2code.springboot.EmployeeCrudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
