package com.example.pet.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.comment.RegiComment;
import com.example.pet.domain.User;
import com.example.pet.domain.UserType;
import com.example.pet.service.MemberService;

@Controller
public class MemberDetailController {
	private String type;
	
	@Autowired
	private MemberService userService;
	
	@ModelAttribute("userTypeList")
	public List<UserType> refUserType() {
		List<UserType> options = new ArrayList<UserType>();
		options.add(new UserType("1", "일반회원"));
		options.add(new UserType("2", "펫시터"));
		
		return options;
	}
	
	@ModelAttribute("updateUser")
	public RegiComment formBacking(HttpServletRequest request, HttpSession session) {
		User beforeUser = (User)request.getSession().getAttribute("user");
		type = beforeUser.getM_type();
		UserType userType = refUserType().get(Integer.parseInt(type) - 1);
		RegiComment updateUser = new RegiComment(beforeUser.getM_num(), beforeUser.getId(), beforeUser.getName(), beforeUser.getNickname(), beforeUser.getPhone(), beforeUser.getAddr(), userType.getValue());
		return updateUser;
	}
	
	@RequestMapping(value={"/view/user/mypage/mypage_profile", "/mypage_main"}, method = RequestMethod.GET)
	public ModelAndView form() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/mypage/mypage_main");
		mav.addObject("url", "profile");
		return mav;
	}
	
	@RequestMapping(value="/view/user/mypage/mypage_profile", method = RequestMethod.POST)
	public ModelAndView updateRegi(@ModelAttribute("updateUser") RegiComment regiForm, HttpSession session, BindingResult bindingResult, Model model) {
		System.out.println("command객체 : " + regiForm);
		
		ModelAndView mav = new ModelAndView();
		
		if (!regiForm.getPw().equals(regiForm.getConfirmPw())) {
			mav.setViewName("user/mypage/mypage_profile");
			mav.addObject("msg", "regiFail");
			return mav;
		}
		
		regiForm.setM_type(type);
		userService.updateUser(regiForm, session);
		System.out.println("update Session : " + session.getAttribute("user"));
		
		mav.setViewName("redirect:/mypage_main");
		mav.addObject("msg", "updateSuccess");
		return mav;
	}
	
	@RequestMapping(value="/view/user/mypage/mypage_delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/mypage/mypage_delete");
		
		return mav;
	}
	
	@RequestMapping(value="/view/user/mypage/mypage_delete", method = RequestMethod.POST)
	public ModelAndView deleteUser(@RequestParam("confirmPw") String confirmPw, HttpSession session) {
		System.out.println("command객체 : " + confirmPw);
		ModelAndView mav = new ModelAndView();
		
		if (!((User)session.getAttribute("user")).getPw().equals(confirmPw))
			mav.setViewName("user/mypage/mypage_delete");
		
		else {
			userService.deleteUser(session);
			
			mav.setViewName("main");
			mav.addObject("msg", "deleteSuccess");
			return mav;
		}
		
		return mav;
	}
}