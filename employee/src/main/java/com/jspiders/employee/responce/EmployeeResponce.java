package com.jspiders.employee.responce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.employee.dto.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponce {

	String msg;

	Employee emp;

	List<Employee> list;
}
