package com.example.pet.controller.usedmarket;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Photo;
import com.example.pet.domain.UsedMarket;
import com.example.pet.domain.User;
import com.example.pet.service.PhotoService;
import com.example.pet.service.UsedMarketService;

@Controller
@RequestMapping("/used_market/*")
public class UpdateUsedMarketController {

	@Inject
	private UsedMarketService usedMarketService;
	@Inject
	private PhotoService photoService;
	
	//used_market/used_market_detail에서 used_market/updateForm 페이지로 가는 mapping
	@RequestMapping("updateForm.do/{uNum}")
	public ModelAndView goToUpdateForm(@PathVariable int uNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("*********** goToUpdateForm : " + uNum + " ***********");
		
		//1. request로 넘어온 uNum 받기
		
		// 2. uNum으로 selectUsedMarketByNum하기, mNum을 변수로 저장
		UsedMarket usedMarketByNum = usedMarketService.selectUsedMarketByNum(uNum);
		int usedMarketmNum = usedMarketByNum.getmNum();
		System.out.println(usedMarketByNum.toString());	
		
		//3. 조회순 내림차순 5개 UsedMarket 찾기
		List<UsedMarket> descHitsUsedMarketList = usedMarketService.selectDescHitsUsedMarket();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("descHitsUsedMarketList", descHitsUsedMarketList); // 데이터를 저장
		
		//4. session에 있는 member 객체 set해 놓기 -> m_num, m_type get해서 변수에 저장
		User user = (User) session.getAttribute("user");
		
		//5. uNum으로 photo 찾기
		System.out.println("**************selectPhotoByuNum***************");
		List<Photo> selectPhotoByuNum = photoService.selectPhotoByuNum(uNum);
		mav.addObject("selectPhotoByuNum", selectPhotoByuNum); // 데이터를 저장
		request.setAttribute("selectPhotoByuNum", selectPhotoByuNum);
		
		if(user != null) {
			int sessionmNum = user.getM_num();	
			String mType = String.valueOf(user.getM_type());
		
			// 5 - 1. mType이 0번이면 관리자라는 의미 -> 관리자는 수정 가능
			// 5 - 2. mType이 1이나 2면, session에 있는 member 객체의 m_num과 변수 mNum 비교하기
			// 5 - 3. 같으면 updateUsedMarket, 다르면 redirection...
			if(mType.equals("0")) {
				System.out.println("************** 관리자, 수정함***************");
				mav.setViewName("used_market/updateForm");
				mav.addObject("usedMarketByNum", usedMarketByNum); // 데이터를 저장
			}
			else {
				if(usedMarketmNum != sessionmNum) {
					System.out.println("************** 넘 다름 안수정***************");
					mav.addObject("usedMarketByNumOrInsert", usedMarketByNum);
					mav.addObject("updateFailed", "true");
					mav.setViewName("used_market/used_market_detail");
				}
				else {
					System.out.println("************** 넘 같음 수정***************");
					mav.setViewName("used_market/updateForm");
					mav.addObject("usedMarketByNum", usedMarketByNum); // 데이터를 저장
				}
			}
		}
		else {
			mav.addObject("usedMarketByNumOrInsert", usedMarketByNum);
			mav.addObject("updateFailed", "true");
			mav.setViewName("used_market/used_market_detail");
		}
		
		return mav;
	}

	
	// UsedMarket 수정
	@RequestMapping("updateUsedMarket/{uNum}")
	public ModelAndView updateUsedMarket(@PathVariable int uNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("************** updateUsedMarket : " + uNum + " **************");		
		//1. update 할 uNum 받기
		
		//2. UsedMarket update
		UsedMarket usedMarket;
		
		if (request.getParameter("usedmarket_expiredate_year").equals("")
				|| request.getParameter("usedmarket_expiredate_month").equals("")
				|| request.getParameter("usedmarket_expiredate_date").equals("")) {
			if(request.getParameter("usedmarket_usedate").equals("X")) {
				usedMarket = new UsedMarket(uNum, Integer.parseInt(request.getParameter("usedmarket_gNum")),
						request.getParameter("usedmarket_title"), request.getParameter("usedmarket_content"),
						Integer.parseInt(request.getParameter("usedmarket_price")));
				
				usedMarketService.updateUsedMarketNoExpireUsedate(usedMarket);
			}
			else {
				usedMarket = new UsedMarket(uNum, Integer.parseInt(request.getParameter("usedmarket_gNum")),
						request.getParameter("usedmarket_title"), request.getParameter("usedmarket_content"),
						request.getParameter("usedmarket_usedate"), Integer.parseInt(request.getParameter("usedmarket_price")));
				
				usedMarketService.updateUsedMarketNoExpiredate(usedMarket);
			}
		} else {
			if(request.getParameter("usedmarket_usedate").equals("X")) {
				usedMarket = new UsedMarket(uNum, Integer.parseInt(request.getParameter("usedmarket_gNum")),
						request.getParameter("usedmarket_title"), request.getParameter("usedmarket_content"),
						Date.valueOf(request.getParameter("usedmarket_expiredate_year") + "-"
								+ request.getParameter("usedmarket_expiredate_month") + "-"
								+ request.getParameter("usedmarket_expiredate_date")),
						Integer.parseInt(request.getParameter("usedmarket_price")));
				
				usedMarketService.updateUsedMarketNoUsedate(usedMarket);
			}
			else {
				usedMarket = new UsedMarket(uNum, Integer.parseInt(request.getParameter("usedmarket_gNum")),
						request.getParameter("usedmarket_title"), request.getParameter("usedmarket_content"),
						request.getParameter("usedmarket_usedate"),
						Date.valueOf(request.getParameter("usedmarket_expiredate_year") + "-"
								+ request.getParameter("usedmarket_expiredate_month") + "-"
								+ request.getParameter("usedmarket_expiredate_date")),
						Integer.parseInt(request.getParameter("usedmarket_price")));
				
				usedMarketService.updateUsedMarket(usedMarket);
			}	
		}
		
		//3. Photo update
		//3 - 1. photo delete
		List<Photo> photos = photoService.selectPhotoByuNum(uNum);
		for(int i = 0; i < photos.size(); i++) 
			photoService.deletePhoto(photos.get(i).getPhotoNum());
		//3 - 2. photo insert
		String[] filePaths = request.getParameter("filePath").split(",");
		int photoNum = 0;
		for(int val : photoService.selectPhotoNum())
			photoNum = val;	
		
		for(int i = 0; i < filePaths.length; i++) {
			System.out.println("새로 삽입 할 사진 번호 : " + photoNum);
			photoNum += 1;
			
			Photo photo = new Photo(photoNum, uNum, filePaths[i]);
			System.out.println(photo.toString());
			photoService.insertPhoto(photo);
		}
			
		//4. used_market_detail.jsp로 수정된 used market, photo 정보 보내기
		UsedMarket usedMarketByNum = usedMarketService.selectUsedMarketByNum(uNum);
		List<Photo> selectPhotoByuNum = photoService.selectPhotoByuNum(uNum);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("used_market/used_market_detail");	//뷰를 question_detail.jsp로 설정
		mav.addObject("usedMarketByNumOrInsert", usedMarketByNum);	//데이터를 저장
		mav.addObject("selectPhotoByuNum", selectPhotoByuNum); // 데이터를 저장
			
		return mav;
	}
	
	// my page에서 used_market의 u_completeTF를 바꿈
	@RequestMapping("updateTF/{uNum}")
	public ModelAndView updateUsedMarketTF(@PathVariable int uNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("*********** updateUsedMarketTF ***********");
		
		// 1. request로 넘어온 uNum 받기
		
		//2. UsedMarket U_COMPLETETF 수정
		usedMarketService.updateUsedMarketTF(uNum);
		
		//3. user/mypage/mypage_main 페이지에 정보 넘기기
		User user = (User) session.getAttribute("user");
		int sessionmNum = user.getM_num();
		
		List<UsedMarket> selectUsedMarketBymNum = usedMarketService.selectUsedMarketBymNum(sessionmNum);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("selectUsedMarketBymNum", selectUsedMarketBymNum);
		mav.addObject("url", "used_market");
		mav.setViewName("user/mypage/mypage_main");
		
		return mav;
	}
}
