package com.example.pet.controller.usedmarket;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Photo;
import com.example.pet.domain.UsedMarket;
import com.example.pet.domain.User;
import com.example.pet.service.PhotoService;
import com.example.pet.service.UsedMarketService;

@Controller
@RequestMapping("/used_market/*")
public class SelectUsedMarketController {

	@Inject
	UsedMarketService usedMarketService;
	@Inject
	private PhotoService photoService;
	
	// 메인 UsedMarket 게시글 페이지, 전체 게시글 목록
	//조회순 내림차순 5개 UsedMarket 찾기
	@RequestMapping("main.do/{str}")
	public ModelAndView selectAllUsedMarket(@PathVariable String str, HttpServletRequest request) throws Exception {
		System.out.println("**************selectAllUsedMarket***************");
		List<UsedMarket> allUsedMarketList = usedMarketService.selectAllUsedMarket();
		ModelAndView mav = new ModelAndView();

		System.out.println("**************selectDescHitsUsedMarket***************");
		List<UsedMarket> descHitsUsedMarketList = usedMarketService.selectDescHitsUsedMarket();
		
		System.out.println("**************selectAllPhoto***************");
		List<Photo> selectAllPhoto = photoService.selectAllPhoto();
		
		mav.setViewName("used_market/used_market_main"); // 뷰를 used_market_main.jsp로 설정
		mav.addObject("allUsedMarketList", allUsedMarketList); // 데이터를 저장
		mav.addObject("descHitsUsedMarketList", descHitsUsedMarketList); // 데이터를 저장
		mav.addObject("allPhoto", selectAllPhoto); // 데이터를 저장
		mav.addObject("select", "all");

		if(str.equals("insertFailed"))
			request.setAttribute("insertFailed", "true");
		
		return mav;
	}

	// search form에서 검색한 결과 보여주기
	@RequestMapping("/search/{findValue}")
	public ModelAndView selectUsedMarketByFindValue(@PathVariable String findValue) throws Exception {
		System.out.println("**************selectUsedMarketByFindValue***************");
		List<UsedMarket> searchQuestionList = usedMarketService.selectUsedMarketByFindValue(findValue);
		
		System.out.println("**************selectDescHitsUsedMarket***************");
		List<UsedMarket> descHitsUsedMarketList = usedMarketService.selectDescHitsUsedMarket();
		
		System.out.println("**************selectAllPhoto***************");
		List<Photo> selectAllPhoto = photoService.selectAllPhoto();

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("used_market/used_market_main"); // 뷰를 used_market_main.jsp로 설정
		mav.addObject("searchQuestionList", searchQuestionList); // 데이터를 저장
		mav.addObject("descHitsUsedMarketList", descHitsUsedMarketList); // 데이터를 저장
		mav.addObject("allPhoto", selectAllPhoto); // 데이터를 저장
		mav.addObject("select", "findValue");

		return mav;
	}

	// g_num으로 게시글 select해서 보여주기
	@RequestMapping("/category/{g_num}")
	public ModelAndView selectUsedMarketByGoodsType(@PathVariable String g_num) throws Exception {
		System.out.println("**************selectUsedMarketByGoodsType***************");
		int gNum = Integer.parseInt(g_num);
		List<UsedMarket> selectUsedMarketByGoodsType = usedMarketService.selectUsedMarketByGoodsType(gNum);

		System.out.println("**************selectDescHitsUsedMarket***************");
		List<UsedMarket> descHitsUsedMarketList = usedMarketService.selectDescHitsUsedMarket();
		
		System.out.println("**************selectAllPhoto***************");
		List<Photo> selectAllPhoto = photoService.selectAllPhoto();

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("used_market/used_market_main");
		mav.addObject("selectUsedMarketByGoodsType", selectUsedMarketByGoodsType);
		mav.addObject("descHitsUsedMarketList", descHitsUsedMarketList); // 데이터를 저장
		mav.addObject("allPhoto", selectAllPhoto); // 데이터를 저장
		mav.addObject("select", "category");

		return mav;
	}

	// u_title 이나 Read More 선택할 경우 uNum으로 UsedMarket 하나 찾아서 보여줌
	//조회순 내림차순 5개 UsedMarket 찾기
	@RequestMapping("/unum/{uNum}")
	public String selectUsedMarketByNum(@PathVariable int uNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************selectUsedMarketByNum***************");
		UsedMarket usedMarketByNum = usedMarketService.selectUsedMarketByNum(uNum);

		System.out.println("**************selectDescHitsUsedMarket***************");
		List<UsedMarket> descHitsUsedMarketList = usedMarketService.selectDescHitsUsedMarket();
		request.setAttribute("descHitsUsedMarketList", descHitsUsedMarketList); // 데이터를 저장

		System.out.println("**************selectPhotoByuNum***************");
		List<Photo> selectPhotoByuNum = photoService.selectPhotoByuNum(uNum);
		request.setAttribute("selectPhotoByuNum", selectPhotoByuNum); // 데이터를 저장

		usedMarketService.updateUsedMarketHits(uNum);

		request.setAttribute("usedMarketByNumOrInsert", usedMarketByNum);

		return "used_market/used_market_detail";
	}

	@RequestMapping(value = "/mypage/{str}", method = RequestMethod.GET)
	public ModelAndView selectMypageQuestion(@PathVariable String str, HttpServletRequest request, HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");

		ModelAndView mav = new ModelAndView();

		if (user == null) {
			mav.setViewName("main");
		} else {
			if (str.equals("pointFailed"))
				mav.addObject("pointFailed", "true");

			int sessionmNum = user.getM_num();

			List<UsedMarket> selectUsedMarketBymNum = usedMarketService.selectUsedMarketBymNum(sessionmNum);

			mav.addObject("selectUsedMarketBymNum", selectUsedMarketBymNum);
			mav.addObject("url", "used_market");
			mav.setViewName("user/mypage/mypage_main");
		}

		return mav;
	}
}
