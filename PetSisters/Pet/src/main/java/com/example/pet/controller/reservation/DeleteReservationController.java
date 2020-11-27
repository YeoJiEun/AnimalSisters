package com.example.pet.controller.reservation;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pet.service.ReservationService;

@Controller
@RequestMapping("/reservation/*")
public class DeleteReservationController {

	@Inject
	ReservationService reservationService;

	// Reservation 상세정보에서 삭제 버튼을 누를 경우 실행
	@RequestMapping("/delete/{b_num}/{m_num}/{r_date}")
	public String deleteReservation(@PathVariable int b_num, @PathVariable int m_num, @PathVariable String r_date, HttpServletRequest request) throws Exception {		
		reservationService.deleteReservation(b_num,m_num,r_date);

		return "redirect:/reservation/main.do";
	}
}
