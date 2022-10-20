package com.jspiders.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.employee.dto.Employee;
import com.jspiders.employee.responce.EmployeeResponce;
import com.jspiders.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<EmployeeResponce> save(@RequestBody Employee emp) {
		Employee savedEmp = service.save(emp);
		return new ResponseEntity<EmployeeResponce>(new EmployeeResponce("Saved Employee successfully", savedEmp, null),
				HttpStatus.ACCEPTED);
	}

	@PostMapping("/update")
	public ResponseEntity<EmployeeResponce> update(@RequestBody Employee emp) {
		Employee updateEmp = service.update(emp);
		return new ResponseEntity<EmployeeResponce>(
				new EmployeeResponce("Saved Employee successfully", updateEmp, null), HttpStatus.ACCEPTED);
	}

	@GetMapping("/search")
	public ResponseEntity<EmployeeResponce> search(@RequestBody Employee emp) {
		Employee search = service.find(emp);
		return new ResponseEntity<EmployeeResponce>(new EmployeeResponce("Employee Found", search, null),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/remove")
	public ResponseEntity<EmployeeResponce> remove(@RequestBody Employee emp) {
		String remove = service.remove(emp);
		return new ResponseEntity<EmployeeResponce>(new EmployeeResponce(remove, null, null), HttpStatus.ACCEPTED);
	}
}
