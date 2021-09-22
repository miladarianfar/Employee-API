package com.employee.restemployee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.restemployee.model.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

	@Override
	@Transactional
	public List<Employee> findByFirstname(String firstname) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("from Employee where firstName =: firstName", Employee.class);
		query.setParameter("firstName", firstname);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	@Transactional
	public List<Employee> findByLastname(String lastname) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("from Employee where lastName =: lastName", Employee.class);
		query.setParameter("lastName", lastname);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	@Transactional
	public List<Employee> findByEmail(String email) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("from Employee where email =: email", Employee.class);
		query.setParameter("email", email);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public long countAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		long count = session.createQuery("SELECT COUNT(e) FROM Employee e", Long.class).getSingleResult();
		
		return count;
	}

}















