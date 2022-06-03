package io.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.crud.model.Employee;
import io.crud.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> showAllEmployees() {
		List<Employee> allEmployees = employeeRepo.findAll();
		return allEmployees;
	}

	@Override
	public ResponseEntity<Employee> showEmployeeById(long id) {
		
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		
		if(optionalEmployee==null) {
			return null;
		}
		
		Employee employee = optionalEmployee.get();
		
		if(null == employee) {
			return new ResponseEntity<Employee>(new Employee(), HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@Override
	public void updateEmployee(Employee updatedEmployee) {

	}

	@Override
	public void deleteEmployee(long id) {

	}

}
