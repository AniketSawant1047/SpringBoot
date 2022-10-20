package com.jspiders.employee.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.employee.dto.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
