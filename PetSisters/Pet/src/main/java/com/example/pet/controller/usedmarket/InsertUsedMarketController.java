package com.example.pet.controller.usedmarket;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Photo;
import com.example.pet.domain.UsedMarket;
import com.example.pet.domain.User;
import com.example.pet.service.PhotoService;
import com.example.pet.service.UsedMarketService;

@Controller
@RequestMapping("/used_market/*")
public class InsertUsedMarketController {

	@Inject
	private UsedMarketService usedMarketService;
	@Inject
	private PhotoService photoService;
	
	//used_market/main에서 used_market/insertForm 페이지로 가는 mapping
	@RequestMapping("insertForm.do")
	public ModelAndView goToInsertForm() throws Exception {
		List<UsedMarket> descHitsUsedMarketList = usedMarketService.selectDescHitsUsedMarket();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("used_market/insertForm");
		mav.addObject("descHitsUsedMarketList", descHitsUsedMarketList); // 데이터를 저장
		
		return mav;
	}
	
	
	//UsedMarket 등록
	@RequestMapping("insertUsedMarket.do")
	public String insertUsedMarket(HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************insertUsedMarket***************");
		String path = "";
		String[] filePaths = request.getParameter("filePath").split(",");

		//1. session에 있는 member 객체 set해 놓기 ->  m_num, m_type get해서 변수에 저장
		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			int mNum = user.getM_num();	
			
			//2. insert 할 uNum 구하기
			int uNum = 0;
			for(int val : usedMarketService.selectUsedMarketNum())
				uNum = val;	
			uNum += 1;
			
			//3. UsedMarket 객체 insert하기			
			if(request.getParameter("usedmarket_expiredate_year").equals("") || request.getParameter("usedmarket_expiredate_month").equals("") || request.getParameter("usedmarket_expiredate_date").equals("")) {
				UsedMarket usedMarket = new UsedMarket(uNum, mNum, Integer.parseInt(request.getParameter("usedmarket_gNum")), 
						request.getParameter("usedmarket_title"), request.getParameter("usedmarket_content"),
						request.getParameter("usedmarket_usedate"), Integer.parseInt(request.getParameter("usedmarket_price")));
				
				usedMarketService.insertUsedMarketNoExpiredate(usedMarket);
			}
			else {
				UsedMarket usedMarket = new UsedMarket(uNum, mNum, Integer.parseInt(request.getParameter("usedmarket_gNum")), 
						request.getParameter("usedmarket_title"), request.getParameter("usedmarket_content"),
						request.getParameter("usedmarket_usedate"), 
						Date.valueOf(request.getParameter("usedmarket_expiredate_year") + "-" + request.getParameter("usedmarket_expiredate_month")	+ "-" + request.getParameter("usedmarket_expiredate_date")),
						Integer.parseInt(request.getParameter("usedmarket_price")));
				
				usedMarketService.insertUsedMarket(usedMarket);
			}
			
			
			//4. Photo insert하기
			int photoNum = 0;
			for(int val : photoService.selectPhotoNum())
				photoNum = val;	
			
			for(int i = 0; i < filePaths.length; i++) {
				photoNum += 1;
				
				Photo photo = new Photo(photoNum, uNum, filePaths[i]);
				System.out.println(photo.toString());
				photoService.insertPhoto(photo);
			}
			

			//5. insert한 UsedMarket객체(+ User객체) 찾아오기
			UsedMarket usedMarketByNum = usedMarketService.selectUsedMarketByNum(uNum);
		
			request.setAttribute("usedMarketByNumOrInsert", usedMarketByNum);
		
			path = "redirect:/used_market/unum/" + uNum;
		}
		else {
			path = "redirect:/used_market/main.do/insertFailed";
		}
	
		return path;
	}
}
