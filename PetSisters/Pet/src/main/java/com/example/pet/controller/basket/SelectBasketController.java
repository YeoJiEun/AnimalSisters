package com.example.pet.controller.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Basket;
import com.example.pet.domain.Board;
import com.example.pet.domain.PetSitter;
import com.example.pet.domain.User;
import com.example.pet.service.BasketService;
import com.example.pet.service.BoardService;
import com.example.pet.service.MemberService;

@Controller
@RequestMapping("/basket/*")
public class SelectBasketController {	

	@Inject
	BasketService basketService;
	@Inject
	MemberService memberService;
	@Inject
	BoardService boardService;
	
	@RequestMapping("all/{m_num}")
	public ModelAndView selectAllBasket(@PathVariable int m_num) throws Exception {
		System.out.println("**************selectAllBasket***************");
		
		List<Basket> allBasketList = basketService.selectAllBasket(m_num);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("basket/basket_main");	//뷰를 basket_main.jsp로 설정
		mav.addObject("allBasketList", allBasketList);	//데이터를 저장
		mav.addObject("select", "all");
		
		return mav;
	}
	
	//메인 Basket 게시글 페이지, 전체 게시글 목록	
	@RequestMapping("/main/{m_num}")
	public ModelAndView selectBasketByNum(@PathVariable int m_num) throws Exception {
		List<Board> basketByNum = basketService.selectBasketByNum(m_num);
		System.out.println("**************selectBasketBym_num***************");
		
		ModelAndView mav = new ModelAndView();
		
		if(basketByNum.size() == 0) {
			mav.addObject("select", "nohave");
		}
		else
			mav.addObject("select", "all");
		
		mav.setViewName("basket/basket_main");
		mav.addObject("allBasketList", basketByNum);	//데이터를 저장
		
		return mav;	
	}
	
	//1. 개인회원 주소와 ~구 가 같은 시터회원을 검색해서 리스트로 검색->돌봄횟수가 가장 높은회원의 게시물을 랜덤으로 검색
	//2. 개인회원 주소와 ~구가 같은 시터회원이 없다면 관심목록에있는 주소 ~시 까지 같으며 관심목록에 더많은 시팅유형과 같고 관심목록에등록된 평균 가격 오차 30%에 드는 게시물 랜덤검색
	//3. 이외의 경우는  더많은 시팅유형과 같고 관심목록에등록된 평균 가격 오차 30%에 드는 게시물 랜덤검색
	@RequestMapping("/recommand.do")
	public ModelAndView recommand( HttpSession session) throws Exception {
		Random r = new Random();
		User user = (User) session.getAttribute("user");
		int m_num = user.getM_num();
		Board boardByNum = new Board();
		
		String mAddr = user.getAddr();
		String w[] = mAddr.split("");
		String word[] = mAddr.split(" "); 
		String firstAddr = w[0]+w[1];
		String midAddr = word[1];
		
		System.out.println("**************recommand***************");
		System.out.println("**************개인주소=" + mAddr +" / ~시 = "+firstAddr+"~구="+word[1]+"***************");
		
		int priceAvg = 0;
		int careAvg = 0;
		int type_1 = 0; //위탁
		int type_2 = 0; //방문
		String type ;
		List<Board> board = basketService.selectBasketByNum(m_num);
	
		System.out.println("**************selectAllBasket***************");
		for(Board b : board) {
			priceAvg += b.getPrice();
			int sitter_num = b.getM_num();
			PetSitter sitter = memberService.selectPetSitter(sitter_num);
			careAvg += sitter.getCareNum();
			if(b.getB_type().equals("위탁시팅"))
				type_1++;
			else
				type_2++;
		}
		
		if(type_1 >= type_2)
			type="위탁시팅";
		else
			type="방문시팅";
		
		priceAvg /= board.size();
		careAvg /= board.size();
		
		System.out.println("평균 가격="+priceAvg+"평균 돌봄횟수="+careAvg);
		List<Board> all = boardService.selectAllBoard();
		List<PetSitter> allSitter = memberService.selectAllPetSitter();
		List<PetSitter> nearSitter = new ArrayList<PetSitter>();
		
		List<Board> recomm = new ArrayList<Board>();
		int care = 0;
		boolean isNear = false;
		for(PetSitter p : allSitter) {
			isNear = p.getAddr().contains(midAddr);
			System.out.println("시터주소="+p.getAddr()+" / 가까운가="+isNear);
			System.out.println("시터주소="+p.getAddr() +" / 시터 번호 ="+p.getM_num());
			if(isNear == true) {
				nearSitter.add(p);
				int newcare = p.getCareNum();
				if(care < newcare) {
					care = newcare;
				}		
			}
			isNear = false;
		}
		
		if(nearSitter.size() == 0) {
			for(Board b : all) {
				if(b.getB_type().equals(type) == true && b.getB_where().contains(firstAddr) && b.getPrice()>priceAvg * 0.7 && b.getPrice()<priceAvg *1.2) {
					recomm.add(b);
				}
			}
			if(recomm.size() == 0) {
				for(Board b : all) {
			
					if(b.getB_type().equals(type) == true && b.getPrice() >priceAvg * 0.7 && b.getPrice()<priceAvg *1.3) {
						recomm.add(b);
					}
				}
			}
			int maxRandom = recomm.size();	
			int ranNum = r.nextInt(maxRandom);
			boardByNum = recomm.get(ranNum);
		}
		else {
			while(nearSitter.size() != 0) {
				int idx = 0;
				int sitter_num = 0;
				for(PetSitter n : nearSitter) {
					if(n.getCareNum() == care) {
						sitter_num = n.getM_num();
						idx = nearSitter.indexOf(n);
					}
					System.out.println("시터주소="+n.getAddr() +"시터 번호 ="+sitter_num);
				}
				
				List<Integer> b_numList = boardService.selectHaveBoardNum(sitter_num);
				if(b_numList.size() != 0) {
					int maxRandom = b_numList.size();
					int ranNum = r.nextInt(maxRandom);
					boardByNum = boardService.selectBoardByNum(b_numList.get(ranNum));
					break;
				}
				else {
					nearSitter.remove(idx);
				}
			}
			if(nearSitter.size() == 0) {
				for(Board b : all) {
					if(b.getB_type().equals(type) == true && b.getB_where().contains(firstAddr) && b.getPrice()>priceAvg * 0.7 && b.getPrice()<priceAvg *1.2) {
						recomm.add(b);
					}
				}
				if(recomm.size() == 0) {
					for(Board b : all) {
				
						if(b.getB_type().equals(type) == true && b.getPrice() >priceAvg * 0.7 && b.getPrice()<priceAvg *1.3) {
							recomm.add(b);
						}
					}
				}
				int maxRandom = recomm.size();	
				int ranNum = r.nextInt(maxRandom);
				boardByNum = recomm.get(ranNum);
			}
		}
		int sitter_num = boardByNum.getM_num();
		PetSitter sitter = memberService.selectPetSitter(sitter_num);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board/board_detail");	//뷰를 basket_main.jsp로 설정
		
		mav.addObject("sitter", sitter);
		mav.addObject("boardByNum", boardByNum);	//데이터를 저장
		mav.addObject("detail", "byNum");
		return mav;
	}
}