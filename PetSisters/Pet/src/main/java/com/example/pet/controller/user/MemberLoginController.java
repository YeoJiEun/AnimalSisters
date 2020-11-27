package com.example.pet.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.comment.LoginComment;
import com.example.pet.domain.User;
import com.example.pet.service.MemberService;

@Controller
public class MemberLoginController {

	@Autowired
	private MemberService userService;
	
	@ModelAttribute("loginCheck")
	public LoginComment formBacking(HttpServletRequest request) {
		return new LoginComment();
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String form() {
		return "user/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute("loginCheck") LoginComment loginCheck, HttpSession session, BindingResult bindingResult, Model model) {
		System.out.println("command객체 : " + loginCheck);
		
		User user = userService.getMemberInfo(loginCheck.getId(), loginCheck.getPw());
		System.out.println("DB객체 : " + user);
		
		boolean result = userService.login(loginCheck, user, session);
		ModelAndView mav = new ModelAndView();
		
		if (!result) {
			mav.setViewName("user/login");
			mav.addObject("msg", "failure");
		}
		else {
			mav.setViewName("main");
			mav.addObject("msg", "success");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletRequest response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("msg", "logout");
		userService.logout(session);
		
		return mav;
	}
}