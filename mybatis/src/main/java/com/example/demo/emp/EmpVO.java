package com.example.demo.emp;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;
	Date hireDate;
	int salary;
	String jobId;
	String departmentId;
	String managerId;
}