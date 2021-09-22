package com.employee.restemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.restemployee.dao.EmployeeDao;
import com.employee.restemployee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDao.findById(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		
		employeeDao.addEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		
		employeeDao.deleteEmployee(id);
	}

	@Override
	public List<Employee> findByFirstname(String firstname) {
		
		return employeeDao.findByFirstname(firstname);
	}

	@Override
	public List<Employee> findByLastname(String lastname) {
		
		return employeeDao.findByLastname(lastname);
	}

	@Override
	public List<Employee> findByEmail(String email) {
		
		return employeeDao.findByEmail(email);
	}

	@Override
	public long countAll() {
		
		return employeeDao.countAll();
	}
	
}
