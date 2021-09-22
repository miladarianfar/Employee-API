package com.employee.restemployee.dao;

import java.util.List;

import com.employee.restemployee.model.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public List<Employee> findByFirstname(String firstname);
	
	public List<Employee> findByLastname(String lastname);
	
	public List<Employee> findByEmail(String email);
	
	public long countAll();
	
	public void addEmployee(Employee employee);
	
	public void deleteEmployee(int id);
}
