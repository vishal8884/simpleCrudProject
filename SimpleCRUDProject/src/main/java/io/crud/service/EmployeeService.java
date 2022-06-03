package io.crud.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.crud.model.Employee;

public interface EmployeeService {

	public ResponseEntity<String> saveEmployee(Employee employee);
	
	public ResponseEntity<List<Employee>> showAllEmployees();
	
	public ResponseEntity<Employee> showEmployeeById(long id);
	
	public void updateEmployee(Employee updatedEmployee);
	
	public void deleteEmployee(long id);
}
