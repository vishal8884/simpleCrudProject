package io.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.crud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
