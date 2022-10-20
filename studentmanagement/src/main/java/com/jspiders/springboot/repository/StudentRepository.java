package com.jspiders.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.dto.StudentDTO;

@Repository
public interface StudentRepository extends CrudRepository<StudentDTO, Integer> {

	List<StudentDTO> findByName(String name);


	StudentDTO findByEmail(String email);

	StudentDTO findByContact(long contact);


	StudentDTO save(Optional<StudentDTO> update);


}
