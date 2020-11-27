package com.example.pet.controller.board;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pet.domain.Board;
import com.example.pet.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class DeleteBoardController {

	@Inject
	BoardService boardService;

	// Board 상세정보에서 삭제 버튼을 누를 경우 실행
	@RequestMapping("/delete/{b_num}")
	public String deleteBoard(@PathVariable int b_num, HttpServletRequest request) throws Exception {
		System.out.println("**************deleteBoard***************");

		Board boardByNum = boardService.selectBoardByNum(b_num);
		int boardmNum = boardByNum.getM_num();
		
		System.out.println("************** b_num : " + boardmNum + "***************");
		
		String mType = "2"; 
		String path = "";
		
		if(mType.equals("0")) {
			boardService.deleteBoard(b_num);
			System.out.println("************** 관리자, 삭제함***************");
			path = "redirect:/board/main.do";
		}
		else {
			boardService.deleteBoard(b_num);
			System.out.println("************** 넘 같음 삭제***************");
			path = "redirect:/board/main.do";	
		}
		
		return path; 
	}
}
