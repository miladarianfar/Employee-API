package com.employee.restemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.restemployee.dao.EmployeeDao;
import com.employee.restemployee.exception.EmployeeNotFoundException;
import com.employee.restemployee.model.Employee;
import com.employee.restemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 
	 * @return List of employees
	 */
	@CrossOrigin
	@GetMapping("/employees")
	public List<Employee> getAll(){
		
		return employeeService.findAll();
	}
	
	/**
	 * 
	 * @param int id
	 * @return single Employee
	 */
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not found with id : " + id);
		}
		
		return employee;
	}
	
	/**
	 * 
	 * @param String firstname
	 * @return List of Employee with first name = firstname 
	 */
	@GetMapping("/employees/firstname/{firstname}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String firstname) {
		
		List<Employee> employees = employeeService.findByFirstname(firstname);
		
		if(employees.size() == 0) {
			throw new EmployeeNotFoundException("Employee not found with firstname : " + firstname);
		}
		
		return employees;
	}
	
	/**
	 * 
	 * @param String lastname
	 * @return List of Employee with last name = lastname 
	 */
	@GetMapping("/employees/lastname/{lastname}")
	public List<Employee> getEmployeeByLastName(@PathVariable String lastname) {
		
		List<Employee> employees = employeeService.findByLastname(lastname);
		
		if(employees.size() == 0) {
			throw new EmployeeNotFoundException("Employee not found with lastname : " + lastname);
		}
		
		return employees;
	}

	/**
	 * 
	 * @param String email
	 * @return List of Employee with email = email 
	 */
	@GetMapping("/employees/email/{email}")
	public List<Employee> getEmployeeByEmail(@PathVariable String email) {
		
		List<Employee> employees = employeeService.findByEmail(email);
		
		if(employees.size() == 0) {
			throw new EmployeeNotFoundException("Employee not found with email : " + email);
		}
		
		return employees;
	}
	
	/**
	 * 
	 * @return number of rows in database
	 */
	@GetMapping("/employees/countAll")
	public String countAll() {
		
		long count = employeeService.countAll();
		
		return "Number of employee : " + count;
	}
	
	/**
	 * 
	 * @param Employee object
	 * @return new employee id
	 */
	@CrossOrigin
	@PostMapping("/employee")
	public int saveEmployee(@RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
		
		return employee.getId();
	}
	
	/**
	 * 
	 * @param id
	 * @return successful message
	 */
	@CrossOrigin
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		employeeService.deleteEmployee(id);
		
		return "Employee deleted!!!";
	}
}
