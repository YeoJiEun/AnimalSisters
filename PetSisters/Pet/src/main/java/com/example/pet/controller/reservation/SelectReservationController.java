package com.example.pet.controller.reservation;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Reservation;
import com.example.pet.domain.User;
import com.example.pet.service.ReservationService;

@Controller
@RequestMapping("/reservation/*")
public class SelectReservationController {	

	@Inject
	ReservationService reservationService;

	/*
	@RequestMapping("main.do")
	public ModelAndView selectAllReservation() throws Exception {
		List<Reservation> allReservationList = reservationService.selectAllReservation();
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("reservation/reservation_main");	//뷰를 reservation_main.jsp로 설정
		mav.addObject("allReservationList", allReservationList);	//데이터를 저장
		mav.addObject("select", "all");
		
		return mav;
	}*/	
		
	//일반회원이 예약목록 보기 
	@RequestMapping("/main.do")
	public ModelAndView selectReservationByNum(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		int m_num = user.getM_num();
		int m_type = Integer.parseInt(user.getM_type());
		
		ModelAndView mav = new ModelAndView();
		
		if(m_type == 1) {
			System.out.println("**************selectReservationByNum***************");
			List<Reservation> reservationByNum = reservationService.selectReservationByNum(m_num);	
		
			mav.setViewName("reservation/reservation_main");
			mav.addObject("reservationByNum", reservationByNum);	//데이터를 저장
			mav.addObject("detail", "m");			
		}
		else{
			int sitter_num = m_num;
			System.out.println("**************selectReservationBySitterNum***************");
			List<Reservation> reservationBySitterNum = reservationService.selectReservationBySitterNum(sitter_num);	
			
			mav.setViewName("reservation/reservation_main");
			mav.addObject("reservationBySitterNum", reservationBySitterNum);	//데이터를 저장
			mav.addObject("detail", "sitter");
		}
		
		return mav;
	}
}