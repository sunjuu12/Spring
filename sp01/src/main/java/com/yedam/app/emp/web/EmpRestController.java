package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@CrossOrigin("*")
//@Controller
@RestController // 내부에 있는 모든 메서드는 데이터를 반환한다는 의미를 포함 => @ResponseBody 생략 가능함.
public class EmpRestController {

	@Autowired
	EmpService empService;

	// 전체조회
	@GetMapping("emps")
	// @ResponseBody
	public List<EmpVO> getEmpList() {
		return empService.getEmpAll();
	}

	// 단건조회
	@GetMapping("emps/{id}")
	// @ResponseBody
	public EmpVO getEmpInfo(@PathVariable Integer id) {
		// id 값을 찾아서 넘겨줌
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(id);
		return empService.getEmpInfo(empVO);
	}

	// 등록
	@PostMapping("emps")
	// @ResponseBody
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO) {
		// queryString이 아니라 JSON 포맷으로 넘어옴
		int eid = empService.insertEmpInfo(empVO);
		Map<String, Object> map = new HashMap<>();
		map.put("result", eid);
		return map;
	}

	// 수정(단건과 등록 결합 상태)
	@PutMapping("emps")
	// @ResponseBody
	public Map<String, Object> UpdateEmpInfo(@PathVariable Integer id, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(id);
		return empService.updateEmpInfo(empVO);
	}

	// 삭제
	@DeleteMapping("emps/{id}")
	// @ResponseBody
	public boolean deleteEmpInfo(@PathVariable Integer id) {
		return empService.deleteEmpInfo(id);
	}
}
