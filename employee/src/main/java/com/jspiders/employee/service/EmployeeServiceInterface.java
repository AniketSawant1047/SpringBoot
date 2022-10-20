package com.jspiders.employee.service;

import com.jspiders.employee.dto.Employee;

public interface EmployeeServiceInterface{

	Employee save(Employee emp);
	
	Employee update(Employee emp);

	Employee find(Employee emp);

	String remove(Employee emp);
	
}
