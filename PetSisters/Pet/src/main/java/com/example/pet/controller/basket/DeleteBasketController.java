package com.example.pet.controller.basket;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.pet.domain.User;
import com.example.pet.service.BasketService;

@Controller
@RequestMapping("/basket/*")
public class DeleteBasketController {

	@Inject
	BasketService basketService;

	// Basket 상세정보에서 삭제 버튼을 누를 경우 실행
	@RequestMapping("/delete/{b_num}")
	public String deleteBasket(@PathVariable int b_num, HttpServletRequest request,HttpSession session) throws Exception {
		System.out.println("**************deleteBasket***************");
		
		User user = (User) session.getAttribute("user");
		int m_num = user.getM_num();
	
		basketService.deleteBasket(b_num);			//넘 같음 삭제

		return "redirect:/basket/main/" + m_num;
	}
}