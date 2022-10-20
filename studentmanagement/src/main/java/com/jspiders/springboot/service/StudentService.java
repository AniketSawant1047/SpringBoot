package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.dto.StudentDTO;
import com.jspiders.springboot.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface {
	@Autowired
	private StudentRepository repository;

	@Override
	public StudentDTO insertStudent(StudentDTO student) {
		if (student != null) {
			StudentDTO savedStudent = repository.save(student);
			return savedStudent;
		}
		return null;
	}

	@Override
	public List<StudentDTO> searchByName(String name) {
		List<StudentDTO> findByName = repository.findByName(name);
		return findByName;
	}

	@Override
	public Optional<StudentDTO> searchById(int id) {
		Optional<StudentDTO> findById = repository.findById(id);
		return findById;
	}

	@Override
	public StudentDTO searchByEmail(String email) {
		StudentDTO findByEmail = repository.findByEmail(email);
		return findByEmail;
	}

	@Override
	public StudentDTO findByContact(long contact) {
		StudentDTO findByContact = repository.findByContact(contact);
		return findByContact;
	}

	@Override
	public String removeStudent(int id) {
		if (id > 0) {
			repository.deleteById(id);
			return "SuccessFully Removed Student";
		}
		return "Student Not found";
	}

	public StudentDTO updateStudent(StudentDTO student) {
		if (student != null) {
			Optional<StudentDTO> update = repository.findById(student.getId());
			StudentDTO updatedStudent = repository.save(update);
			return updatedStudent;
		}
		return null;
	}

}
