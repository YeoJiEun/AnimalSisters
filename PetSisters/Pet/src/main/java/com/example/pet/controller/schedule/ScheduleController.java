package com.example.pet.controller.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pet.domain.Schedule;
import com.example.pet.domain.User;
import com.example.pet.service.ScheduleService;

@Controller
@RequestMapping("/view/schedule/*")
public class ScheduleController {

	@Autowired(required=true)
	private ScheduleService scheduleService;

	@ModelAttribute("schedule")
	public Schedule formSchedule() {
		return new Schedule();
	}

	@RequestMapping(value="/schedule_main", method=RequestMethod.GET)
	public String search( Model model, HttpSession session) {		
		User user = (User)session.getAttribute("user");
		List<Schedule> scheduleArr = scheduleService.selectSchedule(user.getM_num());
		
		for(Schedule element : scheduleArr)
			System.out.println(element.getS_date());
		
		model.addAttribute("scheduleArr", scheduleArr);
		model.addAttribute("url", "schedule");
		
		return "user/mypage/mypage_main";
	}
	
	@RequestMapping(value="/calendar", method=RequestMethod.POST)
	public String calendar(Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		List<Schedule> scheduleArr = scheduleService.selectSchedule(user.getM_num());
		
		session.setAttribute("scheduleArr", scheduleArr);
		
		for(Schedule element : scheduleArr)
			System.out.println(element.getS_date());

		return "schedule/calendar";
	}
	
	@RequestMapping(value="/insert/{num}/{date}", method=RequestMethod.POST)
	public String insert(@PathVariable int num, @PathVariable String date, Model model) {
		Schedule schedule = new Schedule(num, date);
		
		System.out.println("insert schedule: " + schedule.toString());
		
		if(scheduleService.insertSchedule(schedule) != 1)
			System.out.println("insert error");
		
		return "user/mypage/mypage_main";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		if(request.getParameter("deleteArr") != null) {
			String deleteArr[] = request.getParameterValues("deleteArr");
			
			for(String element : deleteArr) {
				int result = scheduleService.deleteSchedule(Integer.parseInt(element));
				
				if(result != 1) 
					System.out.println("delete error");
			}
		}
		
		return "user/mypage/mypage_main";
	}
}
