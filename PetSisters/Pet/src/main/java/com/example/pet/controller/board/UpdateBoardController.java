package com.example.pet.controller.board;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Board;
import com.example.pet.service.BoardService;
import com.example.pet.service.MemberService;

@Controller
@RequestMapping("/board/*")
public class UpdateBoardController {

	@Inject
	BoardService boardService;
	@Inject
	MemberService memberService;

	@RequestMapping("/update/{b_num}")
	public String updateBoard(@PathVariable int b_num, HttpServletRequest request) throws Exception {
		System.out.println("**************updateBoard***************");
		String path = "";
		Board boardByNum = boardService.selectBoardByNum(b_num);
		int boardmNum = boardByNum.getM_num();
		
		Date date = new Date();
		Board board = new Board(b_num, Integer.parseInt(request.getParameter("m_num")), date, request.getParameter("b_where"), Integer.parseInt(request.getParameter("price")),request.getParameter("b_detail"), 
				request.getParameter("b_type"), request.getParameter("b_title"));
		System.out.println("************** b_num : " + boardmNum + "***************");
	
		if(request.getParameter("b_title") == "" || request.getParameter("b_where") == "" || request.getParameter("b_detail") == "" || request.getParameter("price") == "") {
			path = "redirect:/board/update/select/"+b_num;	
			return path;
		}
		
		boardService.updateBoard(board);
		
		path ="redirect:/board/b_num/"+b_num;
		return path;
	}

	@RequestMapping("/update/select/{b_num}")
	public ModelAndView selectBoardByNum(@PathVariable int b_num) throws Exception {
		Board boardByNum = boardService.selectBoardByNum(b_num);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("board/insertForm");
		mav.addObject("boardByNum", boardByNum); // 데이터를 저장
		mav.addObject("detail", "update");

		return mav;
	}
}
