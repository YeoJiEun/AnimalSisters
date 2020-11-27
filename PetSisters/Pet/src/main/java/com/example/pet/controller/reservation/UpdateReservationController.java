
package com.example.pet.controller.reservation;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.pet.domain.Reservation;
import com.example.pet.domain.Schedule;
import com.example.pet.domain.User;
import com.example.pet.service.ReservationService;
import com.example.pet.service.ScheduleService;

@Controller
@RequestMapping("/reservation/*")
public class UpdateReservationController {

	@Inject
	ReservationService reservationService;

	@Autowired(required=true)
	private ScheduleService scheduleService;

	@RequestMapping("/update/confirm/{b_num}/{m_num}/{r_date}")
	public String updateReservation(@PathVariable int b_num, @PathVariable int m_num,  @PathVariable String r_date, HttpServletRequest request,HttpSession session) throws Exception {
		System.out.println("**************updateReservation***************");
		User user = (User) session.getAttribute("user");
		int sitter_num = user.getM_num();
		
		System.out.println("**************updateReservation"+b_num+" "+m_num+" "+r_date+"**************");
		Reservation b = reservationService.selectReservation(b_num, m_num, r_date);

		b.setR_confirmTF("T");

		reservationService.updateReservation(b);
		int Num = 0;
		for(int val : scheduleService.selectScheduleNum())
			Num = val;	
		Num = Num+1;
		System.out.println("**************s_num="+Num+"***************");
		scheduleService.insertSchedule2(new Schedule(Num,sitter_num,b.getR_date()));

		return "redirect:/reservation/main.do";
	}

	@RequestMapping("/update/complete/{b_num}/{m_num}/{r_date}")
	public String updateReservation2(@PathVariable int b_num, @PathVariable int m_num, @PathVariable String r_date, HttpServletRequest request) throws Exception {
		System.out.println("**************updateReservation : " + b_num + ", " + m_num + ", " + r_date + "**************");
		
		Reservation b = reservationService.selectReservation(b_num, m_num,r_date);	
		b.setR_completeTF("T");

		reservationService.updateReservation(b);
		
		if (b.getR_completeTF().equals("T") && b.getR_confirmTF().equals("T")) {
			int sitterNum = reservationService.findSitter(b_num);
			System.out.println("Find sitter : " + sitterNum);
			
			reservationService.updateCareNum(sitterNum);
			scheduleService.deleteSchedule2(sitterNum,b.getR_date());
			reservationService.deleteReservation(b_num,m_num,r_date);	
		}

		return "redirect:/reservation/main.do";
	}
}
