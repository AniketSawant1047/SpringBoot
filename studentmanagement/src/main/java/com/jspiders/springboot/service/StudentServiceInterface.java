package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import com.jspiders.springboot.dto.StudentDTO;

public interface StudentServiceInterface {

	StudentDTO insertStudent(StudentDTO student);

	List searchByName(String name);

	StudentDTO searchByEmail(String email);

	StudentDTO findByContact(long contact);
	
	String removeStudent(int id);

	Optional<StudentDTO> searchById(int id);
}
