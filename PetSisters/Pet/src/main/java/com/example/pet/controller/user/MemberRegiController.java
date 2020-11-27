package com.example.pet.controller.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.comment.PetSitterComment;
import com.example.pet.comment.RegiComment;
import com.example.pet.domain.UserType;
import com.example.pet.service.MemberService;

@Controller
public class MemberRegiController {
	private String uploadDir;
	
	@Autowired
	private MemberService userService;
	
	@ModelAttribute("userTypeList")
	public List<UserType> refUserType() {
		List<UserType> options = new ArrayList<UserType>();
		
		options.add(new UserType("1", "일반회원"));
		options.add(new UserType("2", "펫시터"));
		
		return options;
	}
	
	@ModelAttribute("regiForm")
	public RegiComment formBacking(HttpServletRequest request) {
		return new RegiComment();
	}
	
	@ModelAttribute("sitterForm")
	public PetSitterComment formBacking2(HttpServletRequest request) {
		return new PetSitterComment();
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String form() {
		return "user/register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("regiForm") RegiComment regiForm, @ModelAttribute("sitterForm") PetSitterComment sitterForm, HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("command객체 : " + regiForm + "\ncommand객체2 : " + sitterForm);
		
		ModelAndView mav = new ModelAndView();
		
		if (!regiForm.getPw().equals(regiForm.getConfirmPw())) {
			mav.setViewName("redirect:/register");
			mav.addObject("msg", "regiFail");
			return mav;
		}
		
		MultipartFile picture = sitterForm.getPicture();
		boolean uploadSuccess = uploadFile(request, picture);
		userService.insertUser(regiForm, sitterForm, picture.getOriginalFilename());
		
		if (sitterForm.getPicture() != null && !uploadSuccess) {
			mav.setViewName("redirect:/register");
			mav.addObject("msg", "regiFail");
		}
		
		mav.setViewName("main");
		mav.addObject("msg", "regiSuccess");
		return mav;
	}
	
	private boolean uploadFile(HttpServletRequest request, MultipartFile report) {
		String path = request.getSession().getServletContext().getRealPath("/");
		path = path.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Pet\\", "Pet\\src\\main\\webapp\\resources\\img\\petsitter\\petsitter");
		uploadDir = path;
		
		System.out.println(this.uploadDir);
		System.out.println("업로드 한 파일: " + report.getOriginalFilename());
		
		File file = new File(this.uploadDir + report.getOriginalFilename());
		try {
			report.transferTo(file);
			return true;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}