package com.example.pet.controller.basket;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Basket;
import com.example.pet.domain.Board;
import com.example.pet.service.BasketService;

@Controller
@RequestMapping("/basket/*")
public class InsertBasketController {

	@Inject
	BasketService basketService;
	
	//메인 Basket 게시글 페이지, 전체 게시글 목록
	boolean isHave = false;
	boolean overSize = false;
	
	@RequestMapping("/insert/{m_num}/{b_num}")
	public ModelAndView insertBasket(@PathVariable int m_num ,@PathVariable int b_num ,HttpServletRequest request) throws Exception {
		System.out.println("**************insertBasket***************");
		ModelAndView mav = new ModelAndView();
		Basket basket = new Basket(b_num, m_num);
		
		basketService.insertBasket(basket);
		
		List<Board> basketByNum = basketService.selectBasketByNum(m_num);
		
		mav.setViewName("basket/basket_main");
		mav.addObject("allBasketList", basketByNum);	//데이터를 저장
		mav.addObject("select", "all");
		
		return mav;	
	
	}
}