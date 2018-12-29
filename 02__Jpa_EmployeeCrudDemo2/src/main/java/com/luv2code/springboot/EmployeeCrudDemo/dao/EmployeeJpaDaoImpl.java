package com.luv2code.springboot.EmployeeCrudDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;

@Repository
public class EmployeeJpaDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeJpaDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// create a query
		Query theQuery = entityManager.createQuery("from Employee");

		// execute the query and get result list
		List<Employee> theEmployee = theQuery.getResultList();
		return theEmployee;
	}

	@Override
	public Employee findbyId(int theId) {
		// get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);

		// update with id from db ... so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(int theId) {
		
		Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
