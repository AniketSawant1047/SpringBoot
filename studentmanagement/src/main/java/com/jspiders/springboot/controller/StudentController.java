package com.jspiders.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.dto.StudentDTO;
import com.jspiders.springboot.response.StudentResponse;
import com.jspiders.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/")
	public String in() {
		return "<h1> Hello word <h1>";
	}

	@PostMapping("/insert")
	private ResponseEntity<StudentResponse> insertStudent(@RequestBody StudentDTO student) {
		StudentDTO insertedStudent = service.insertStudent(student);
		return new ResponseEntity<StudentResponse>(new StudentResponse("OK", "Student inserted", insertedStudent, null),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/searchByName")
	private ResponseEntity<StudentResponse> searchByName(@RequestBody StudentDTO student) {
		List searchByName = service.searchByName(student.getName());
		return new ResponseEntity<StudentResponse>(new StudentResponse("OK", "Student Found",  null, searchByName),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/searchById")
	private ResponseEntity<StudentResponse> searchById(@RequestBody StudentDTO student) {
		Optional<StudentDTO> searchByID = service.searchById(student.getId());
		return new ResponseEntity<StudentResponse>(new StudentResponse("Ok", "Student Found", null, null),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/searchByEmail")
	private ResponseEntity<StudentResponse> searchByEmail(@RequestBody StudentDTO student) {
		StudentDTO searchByEmail = service.searchByEmail(student.getEmail());
		return new ResponseEntity<StudentResponse>(new StudentResponse("Ok", "Student Found", searchByEmail, null),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/searchByContact")
	private ResponseEntity<StudentResponse> searchByContact(@RequestBody StudentDTO student) {
		StudentDTO searchByContact = service.findByContact(student.getContact());
		return new ResponseEntity<StudentResponse>(new StudentResponse("Ok", "Student Found", searchByContact, null),
				HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/remove")
	private ResponseEntity<StudentResponse> removeStudent(@RequestBody StudentDTO student) {
		String removeStudent = service.removeStudent(student.getId());
		return new ResponseEntity<StudentResponse>(new StudentResponse("OK", removeStudent, null, null),
				HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Update")
	private ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentDTO student) {
		StudentDTO updateStudent = service.updateStudent(student);
		return new ResponseEntity<StudentResponse>(new StudentResponse("OK", "Student Updated", updateStudent, null),
				HttpStatus.ACCEPTED);
	}
	

}
