package com.yedam.app.emp.service;

import lombok.Data;

@Data // emp에서 쓸 거라 getter, setter 필요
public class EmpVO {
	String employee_id;
	String last_name;
	String email;
	String hire_date;
	String job_id;
}
