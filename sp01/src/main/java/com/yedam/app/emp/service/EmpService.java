package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	// 전체조회
	public List<EmpVO> getEmpAll();

	// 단건조회
	public EmpVO getEmpInfo(EmpVO empVO);

	// 등록
	public int insertEmpInfo(EmpVO empVO);

	// 수정 service가 하는 역할은 없고 mapper의 서비스 받아서 그대로 넘김
	public Map<String, Object> updateEmpInfo(EmpVO empVO);

	// 삭제
	public boolean deleteEmpInfo(int empId);
}
