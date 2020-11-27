package com.example.pet.controller.user;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.comment.PetSitterComment;
import com.example.pet.domain.PetSitter;
import com.example.pet.domain.User;
import com.example.pet.service.MemberService;

@Controller
public class PetSitterController implements ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(PetSitterController.class);
	
	private WebApplicationContext context;	
//	@Resource(name="uploadDir")
	private String uploadDir;

	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
	}
	
	@Autowired
	private MemberService userService;
	
	@ModelAttribute("sitterForm")
	public PetSitterComment formBacking(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		String path = request.getSession().getServletContext().getRealPath("/");
		String[] s = path.split(".metadata");
		path = s[0] + "Pet\\src\\main\\webapp\\resources\\img\\petsitter\\petsitter";
//		path = path.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Pet\\", "Pet\\src\\main\\webapp\\resources\\img\\petsitter\\petsitter");
		System.out.println(path);
		
		uploadDir = path;
		
		PetSitter petSitter = userService.selectPetSitter(user.getM_num());
		PetSitterComment sitterForm = new PetSitterComment();
		
		if (petSitter != null) {
			sitterForm.setAge(petSitter.getAge());
			sitterForm.setCareNum(petSitter.getCareNum());
			sitterForm.setPictureUrl(petSitter.getPicture());
//			sitterForm.setPictureUrl(path + petSitter.getPicture());
		}
		
		return sitterForm;
	}
	
	@RequestMapping(value="/view/user/mypage/mypage_petsitter", method = RequestMethod.GET)
	public ModelAndView form(@ModelAttribute("sitterForm") PetSitterComment sitterForm) {
		File file = new File(sitterForm.getPictureUrl());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/mypage/mypage_main");
		mav.addObject("url", "petsitter");
		mav.addObject("file", file);
		return mav;
	}
	
	@RequestMapping(value="/view/user/mypage/mypage_petsitter", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("sitterForm") PetSitterComment sitterComment, HttpSession session, BindingResult bindingResult, Model model) {
		System.out.println("command객체 : " + sitterComment);
		
		ModelAndView mav = new ModelAndView();
		
		MultipartFile picture = sitterComment.getPicture();
		boolean uploadSuccess = uploadFile(picture);
		
		if (uploadSuccess) {
			User user = (User) session.getAttribute("user");
			
			userService.updatePetSitter(user.getM_num(), sitterComment, picture.getOriginalFilename());
			
			mav.setViewName("user/mypage/mypage_main");
			mav.addObject("msg", "petsitterSuccess");
		} else {
			mav.addObject("sitterForm", sitterComment);
			mav.setViewName("user/mypage/mypage_main");
		}
		
		return mav;
	}
	
	private boolean uploadFile(MultipartFile report) {
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

