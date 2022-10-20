package com.jspiders.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspiders.employee.dao.EmployeeRepository;
import com.jspiders.employee.dto.Employee;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee save(Employee emp) {
		if (emp != null) {
			Employee savedEmp = repository.save(emp);
			return savedEmp;
		}
		return null;
	}

	@Override
	public Employee update(Employee emp) {
		if(emp != null) {
			Optional<Employee> findEmp = repository.findById(emp.getId());
			repository.delete(findEmp.get());
			Employee updateEmp = repository.save(emp);
			return updateEmp;
		}
		return null;
	}
	@Override
	public Employee find(Employee emp) {
		if (emp != null) {
			Optional<Employee> findById = repository.findById(emp.getId());
			return findById.get();
		}
		return null;
	}
	@Override
	public String remove(Employee emp) {
		if (emp != null) {
			repository.delete(emp);
			return "Removed Employee Successully..";	
		}
		return null;
	}

	
}
