package com.luv2code.springboot.EmployeeCrudDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.EmployeeCrudDemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the current  session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a hibernate query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> employee = theQuery.getResultList();
		return employee;
	}

	@Override
	public Employee findbyId(int theId) {
		// get the current  session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the employee
		Employee theEmployee = currentSession.find(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// get the current  session
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void delete(int theId) {
		// get the current  session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
	}

}
