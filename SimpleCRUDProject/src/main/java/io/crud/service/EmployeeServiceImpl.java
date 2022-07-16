package io.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.crud.model.Employee;
import io.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public ResponseEntity<String> saveEmployee(Employee employee) {
	    employeeRepo.save(employee);
		return new ResponseEntity<String>("Saved employee successfully", HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<Employee>> showAllEmployees() {
		List<Employee> allEmployees = employeeRepo.findAll();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
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
