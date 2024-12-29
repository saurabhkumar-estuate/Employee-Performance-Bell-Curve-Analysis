package com.est.employee.performance.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.est.employee.performance.model.Employee;

@Repository
public class EmployeeRepository {
	
	private final List<Employee> employees = new ArrayList<>();
	
	public EmployeeRepository() {
	
	
	employees.add(new Employee(5001, "Harry", 1, "A"));
    employees.add(new Employee(5002, "Harry", 3, "B"));
    employees.add(new Employee(5003, "Harry", 4, "C"));
    employees.add(new Employee(5004, "Harry", 2, "D"));
    employees.add(new Employee(5005, "Harry", 5, "E"));
    employees.add(new Employee(5006, "Harry", 7, "A"));
    employees.add(new Employee(5007, "Harry", 6, "C"));
    employees.add(new Employee(5008, "Harry", 8, "D"));
    employees.add(new Employee(5009, "Harry", 9, "B"));
    employees.add(new Employee(5010, "Harry", 10, "E"));
    employees.add(new Employee(5011, "Harry", 13, "A"));
    employees.add(new Employee(5012, "Harry", 12, "C"));
    employees.add(new Employee(5013, "Harry", 14, "D"));
    employees.add(new Employee(5014, "Harry", 15, "C"));
    employees.add(new Employee(5015, "Harry", 11, "E"));
    
    
	}
	
	public List<Employee> findAll() {
	    return employees;
	}
	
	
}
