package com.yedam.app.board.web;

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

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	// 전체조회 : URI - boardList / RETURN -board/boardList
	@GetMapping("boardList")
	public String getboardList(Model model) {
		List<BoardVO> list = boardService.getBoardAll();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}

	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}

	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardInfoForm() {
		return "board/boardInsert";
	}

	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO / RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String insertBoardInfoProcess(BoardVO boardVO) {
		/*
		 * int boardNo = boardService.insertBoardInfo(boardVO);
		 * 
		 * String path = null; if (boardNo > -1) { path =
		 * "redirect:boardInfo/${boardNo}"; } else { path = "redirect:boardList"; }
		 * return path;
		 */
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
	}

	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO / RETURN -
	// board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		BoardVO findVo = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVo);
		return "board/boardUpdate";
	}

	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody // 없으면 ajax 동작 못 함.
	public Map boardUpdateProcess(@RequestBody BoardVO boardVO, Model model) {
		return boardService.updateBoardInfo(boardVO);
	}

	// 삭제
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}
}
