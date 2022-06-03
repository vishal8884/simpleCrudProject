package io.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.crud.model.Employee;
import io.crud.repository.EmployeeRepository;
import io.crud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/crud")
@Slf4j
public class Controller {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/test")
	public ResponseEntity<String> testUrl(){
		return new ResponseEntity<String>("Working", HttpStatus.OK);
	}
	
	@PostMapping(value = "/addEmployee", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		return employeeService.saveEmployee(employee);
	}
	
	
	@GetMapping(value = "/showAllEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> showAllEmployees(){
		return employeeService.showAllEmployees();
	}
	
	@GetMapping(value = "/showEmployee/{id}")
	public ResponseEntity<Employee> showEmployeeById(@PathVariable("id") long id){
		return employeeService.showEmployeeById(id);
	}
	
	
	@PutMapping(value = "/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee updatedEmployee) {
		
		long id = updatedEmployee.getId();
		
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		if(optionalEmployee==null) {
			return new ResponseEntity<String>("employee does not exist", HttpStatus.NO_CONTENT);
		}
		
		employeeRepo.save(updatedEmployee);
		
		return new ResponseEntity<String>("updated employee successfully", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		if(optionalEmployee==null) {
			return new ResponseEntity<String>("employee does not exist", HttpStatus.NO_CONTENT);
		}
		
		employeeRepo.deleteById(id);
		
		return new ResponseEntity<String>("deleted employee successfully", HttpStatus.OK);
	}
}
