package com.example.pet.controller.reservation;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Reservation;
import com.example.pet.domain.Schedule;
import com.example.pet.domain.User;
import com.example.pet.service.ReservationService;
import com.example.pet.service.ScheduleService;

@Controller
@RequestMapping("/reservation/*")
public class InsertReservationController {

	@Inject
	ReservationService reservationService;
	
	@Autowired(required=true)
	private ScheduleService scheduleService;
	
	//메인 Reservation 게시글 페이지, 전체 게시글 목록
	@RequestMapping("insert/real/{b_num}")
	public ModelAndView realInsertReservation(@PathVariable int b_num, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************insertReservation***************");
		User user = (User) session.getAttribute("user");
		int m_num = user.getM_num();
		
		String date = request.getParameter("r_date");
		System.out.println("**************date="+date+"***************");
	
		int sitterNum = reservationService.findSitter(b_num);
		Reservation reservation = new Reservation(b_num,"F","F",date, m_num, sitterNum);
		reservationService.insertReservation(reservation);
		
		List<Reservation> reservationByNum = reservationService.selectReservationByNum(m_num);
		
		ModelAndView mav = new ModelAndView();
			
		mav.setViewName("reservation/reservation_main");

		mav.addObject("reservationByNum", reservationByNum);	
		mav.addObject("detail", "m");	
		return mav;
		
	}
	
	@RequestMapping("insert/{b_num}")
	public ModelAndView insertReservation(@PathVariable int b_num, HttpServletRequest request, HttpSession session) throws Exception {		
		System.out.println("**************insertReservation***************");
		
		int sitterNum = reservationService.findSitter(b_num);
		List<Schedule> sl = scheduleService.selectSchedule(sitterNum);
		String rslt = "";
		for(Schedule a : sl) {
			rslt += a.getS_date()+"/";
		}
		System.out.println("***********schedule"+rslt+"***************");
		
		ModelAndView mav = new ModelAndView();
			
		mav.setViewName("reservation/calendar");
		mav.addObject("StringSche", rslt);
		mav.addObject("schedule", sl);
		mav.addObject("b_num", b_num);	
		mav.addObject("sitter_num", sitterNum);
		
		return mav;
	}
}
