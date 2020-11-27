package com.example.pet.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.pet.domain.PetSitter;
import com.example.pet.domain.User;
import com.example.pet.domain.Basket;
import com.example.pet.domain.Board;
import com.example.pet.service.BasketService;
import com.example.pet.service.BoardService;
import com.example.pet.service.MemberService;

@Controller
@RequestMapping("/board/*")
public class SelectBoardController {	

	@Inject
	BoardService boardService;
	@Inject
	MemberService memberService;
	@Inject
	BasketService basketService;
	
	//메인 Board 게시글 페이지, 전체 게시글 목록
	@RequestMapping("main.do")
	public ModelAndView selectAllBoard() throws Exception {
		System.out.println("**************selectAllBoard***************");
		
		List<Board> allBoardList = boardService.selectAllBoard();
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board/board_main");	//뷰를 board_main.jsp로 설정
		mav.addObject("allBoardList", allBoardList);	//데이터를 저장
		mav.addObject("select", "all");
		
		return mav;
	}
	
	//b_num으로 게시글 select해서 보여주기
	@RequestMapping("/b_num/{b_num}")
	public ModelAndView selectBoardByNum(@PathVariable int b_num,HttpSession session ) throws Exception {
		boolean overSize = false;
		boolean isHave = false;
		
		if(session.getAttribute("user") == null) {
			Board boardByNum = boardService.selectBoardByNum(b_num);
			int sitter_num = boardByNum.getM_num();
			PetSitter sitter = memberService.selectPetSitter(sitter_num);
		
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("board/board_detail");
			mav.addObject("sitter", sitter);
			mav.addObject("boardByNum", boardByNum);	//데이터를 저장
			mav.addObject("detail", "byNum");
			
			return mav;
		}
		else {
			User user = (User) session.getAttribute("user");
			int m_num = user.getM_num();
			Board boardByNum = boardService.selectBoardByNum(b_num);
			int sitter_num = boardByNum.getM_num();
			PetSitter sitter = memberService.selectPetSitter(sitter_num);
			ModelAndView mav = new ModelAndView();
			
			List<Basket> allBasketList = basketService.selectAllBasket(m_num);
			
			for(int i = 0; i < allBasketList.size(); i++) {
				if(allBasketList.get(i).getB_num() == b_num) {
					isHave = true;
				}
			}
			
			int size = allBasketList.size();
			if(size >=5)
				overSize = true;
			if(overSize == true)
				mav.addObject("overSize","true");
			else
				mav.addObject("overSize","false");
			
			if(isHave == false) 
				mav.addObject("isHave","false");
			else
				mav.addObject("isHave","true");
					
			mav.setViewName("board/board_detail");
			mav.addObject("sitter", sitter);
			mav.addObject("boardByNum", boardByNum);	//데이터를 저장
			mav.addObject("detail", "byNum");
			
			return mav;
		}	
	}
	
	//search form에서 검색한 결과 보여주기
	@RequestMapping("/search/{findValue}")
	public ModelAndView selectBoardByFindValue(@PathVariable String findValue) throws Exception {
		System.out.println("**************selectBoardByFindValue***************");
		System.out.println("**************" + findValue + "***************");

		List<Board> searchBoardList = boardService.selectBoardByFindValue(findValue);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_main");	//뷰를 board_main.jsp로 설정
		mav.addObject("searchBoardList", searchBoardList);	//데이터를 저장
		mav.addObject("select", "findValue");
		
		return mav;
	}
}