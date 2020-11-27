package com.example.pet.controller.usedmarket;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pet.domain.Photo;
import com.example.pet.domain.UsedMarket;
import com.example.pet.domain.User;
import com.example.pet.service.PhotoService;
import com.example.pet.service.UsedMarketService;

@Controller
@RequestMapping("/used_market/*")
public class DeleteUsedMarketController {

	@Inject
	UsedMarketService usedMarketService;
	@Inject
	private PhotoService photoService;
	
	// UsedMarket 상세정보에서 삭제 버튼을 누를 경우 실행
	@RequestMapping("delete/{uNum}")
	public String deleteUsedMarket(@PathVariable int uNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************deleteUsedMarket***************");
		
		// 1. uNum 받기
		
		// 2. uNum으로 selectUsedMarketByNum하기, mNum을 변수로 저장
		UsedMarket usedMarketByNum = usedMarketService.selectUsedMarketByNum(uNum);
		int usedMarketmNum = usedMarketByNum.getmNum();
	
		// 3. session에 있는 member 객체 set해 놓기 -> m_num, m_type get해서 변수에 저장
		User user = (User) session.getAttribute("user");
		String path = "";
		
		if(user != null) {
			int sessionmNum = user.getM_num();	
			String mType = String.valueOf(user.getM_type());	

			// 4 - 1. mType이 0번이면 관리자라는 의미 -> 관리자는 삭제 가능
			// 4 - 2. mType이 1이나 2면, session에 있는 member 객체의 m_num과 변수 mNum 비교하기
			// 4 - 3. 같으면 deleteUsedMarket, 다르면 redirection...
			if(mType.equals("0")) {
				//photo 삭제
				List<Photo> photos = photoService.selectPhotoByuNum(uNum);
				for(int i = 0; i < photos.size(); i++) 
					photoService.deletePhoto(photos.get(i).getPhotoNum());
					
				usedMarketService.deleteUsedMarket(uNum);
				
				System.out.println("************** 관리자, 삭제함***************");
				path = "redirect:/used_market/main.do/main";
			}
			else {
				if(usedMarketmNum != sessionmNum) {
					System.out.println("************** 넘 다름 안삭제***************");
					request.setAttribute("usedMarketByNumOrInsert", usedMarketByNum);
					request.setAttribute("deleteFailed", "true");
					path = "used_market/used_market_detail";
				}
				else {					
					//photo 삭제
					List<Photo> photos = photoService.selectPhotoByuNum(uNum);
					for(int i = 0; i < photos.size(); i++) 
						photoService.deletePhoto(photos.get(i).getPhotoNum());
					
					usedMarketService.deleteUsedMarket(uNum);
					
					System.out.println("************** 넘 같음 삭제***************");
					path = "redirect:/used_market/main.do/main";
				}
			}
		}
		else {
			request.setAttribute("usedMarketByNumOrInsert", usedMarketByNum);
			request.setAttribute("deleteFailed", "true");
			path = "used_market/used_market_detail";
		}
		return path; 
	}
}
