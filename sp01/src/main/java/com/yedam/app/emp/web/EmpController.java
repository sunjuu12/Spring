package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;

	// GET : 단순 조회, 빈페이지 호출(ex 회원가입, 게시글 작성 시)
	// POST : 데이터 조작(등록, 수정, 삭제)

	// 전체조회
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList"; // 폴더를 기준으로 구분하는 것이 좋음. viewresolver에게 넘어감
	}

	// 사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) { // 필드 내부의 값으로 값 입력
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";
	}

	// 사원등록 - FROM
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}

	// 사원등록 - PROCESS
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);

		String path = null;
		if (empId > -1) {
			path = "redirect:empInfo?employeeId=" + empId;
		} else {
			path = "redirect:empList";
		}
		return path;
	}

	// 사원수정 - PROCESS : 페이지 전환 없이 Ajax로 만들어짐 => @ResponseBody
	// 1) QueryString => 커맨드 객체
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}

	// 2) JSON => @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}

	// 사원삭제 - PROCESS (주로 POST쓰나 GET도 가능)
	@GetMapping("empDelete")
	public String empDelete(@RequestParam Integer eid) {
		empService.deleteEmpInfo(eid);
		return "redirect:empList";
	}
}
