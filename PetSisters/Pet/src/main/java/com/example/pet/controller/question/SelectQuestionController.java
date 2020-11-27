package com.example.pet.controller.question;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Question;
import com.example.pet.domain.User;
import com.example.pet.service.QuestionService;

@Controller
@RequestMapping("/question/*")
public class SelectQuestionController {	

	@Autowired
	private QuestionService questionService;

	//메인 Question 게시글 페이지, 전체 게시글 목록
	@RequestMapping("main.do/{str}")
	public ModelAndView selectAllQuestion(@PathVariable String str, HttpServletRequest request) throws Exception {
		System.out.println("**************selectAllQuestion***************");
		
		List<Question> allQuestionList = questionService.selectAllQuestion();
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("question/question_main");	//뷰를 question_main.jsp로 설정
		mav.addObject("allQuestionList", allQuestionList);	//데이터를 저장
		mav.addObject("select", "all");
		
		if(str.equals("selectFailed")) 
			 request.setAttribute("selectFailed", "true");
		else if(str.equals("insertFailed"))
			request.setAttribute("insertFailed", "true");
		
		return mav;
	}
	
	//m_type으로 게시글 select해서 보여주기
	@RequestMapping("/m_type/{mType}")
	public ModelAndView selectQuestionByMType(@PathVariable String mType) throws Exception {
		List<Question> mTypeQuestionList = questionService.selectAllQuestion();
		String select = "";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("question/question_main");
		
		switch(mType) {
			case "all" :
				System.out.println("________________all select_________");
				select = "all";
				mTypeQuestionList = questionService.selectAllQuestion();
				mav.addObject("allQuestionList", mTypeQuestionList);	//데이터를 저장
				break;
			case "normal" :
				System.out.println("________________일반회원 select_________");
				select = "mType";
				mTypeQuestionList = questionService.selectQuestionByMType("1");
				mav.addObject("mTypeQuestionList", mTypeQuestionList);	//데이터를 저장
				break;
			case "petsitter" :
				System.out.println("________________펫시터 select_________");
				select = "mType";
				mTypeQuestionList = questionService.selectQuestionByMType("2");
				mav.addObject("mTypeQuestionList", mTypeQuestionList);	//데이터를 저장
				break;	
		}		
		
		mav.addObject("select", select);
		
		return mav;	
	}
	
	//search form에서 검색한 결과 보여주기
	@RequestMapping("/search/{findValue}")
	public ModelAndView selectQuestionByFindValue(@PathVariable String findValue) throws Exception {
		System.out.println("**************selectQuestionByFindValue***************");

		List<Question> searchQuestionList = questionService.selectQuestionByFindValue(findValue);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("question/question_main");	//뷰를 question_main.jsp로 설정
		mav.addObject("searchQuestionList", searchQuestionList);	//데이터를 저장
		mav.addObject("select", "findValue");
		
		return mav;
	}
	
	//question title 선택할 경우 questionNum으로 question하나 찾아서 보여줌
	@RequestMapping("/qnum/{questionNum}")		//ModelAndView
	public String selectQuestionByNum(@PathVariable int questionNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************selectQuestionByNum***************");
		//1. session에 있는 member 객체 set해 놓기 -> m_num, m_type get해서 변수에 저장
		User user = (User) session.getAttribute("user");
		int sessionmNum;
		int sessionmType;

		//2. 넘어온 questionNum으로 해당하는 Question 객체 찾기
		Question questionByNum = questionService.selectQuestionByNum(questionNum);
		int questionnNum = questionByNum.getmNum();
		
		String path = "";
		
		//3. session의 nNum과 question의 nNum을 비교
		//3-1. 세션에 user 객체가 없으면 || 다르면 || mType이 0이면
		//3-2. 같으면
		if(user == null) {
			System.out.println("************** 객체 없음 ***************");
			path = "redirect:/question/main.do/selectFailed";
		}
		else {
			sessionmNum = user.getM_num();
			sessionmType = Integer.parseInt(user.getM_type());
			
			if(sessionmNum == questionnNum || sessionmType == 0) {
				//hits ++ (main에서 title 눌러서 detail 페이지 들어갈 경우에만 hits 오르게하기)
				questionService.updateQuestionHits(questionNum);
			
				request.setAttribute("questionByNumOrInsert", questionByNum);

				path = "question/question_detail";
			}
			else {
				System.out.println("************** 객체 있고다름 ***************");
				path = "redirect:/question/main.do/selectFailed";
			}
		}
		
		return path;
	}
	
	//mypage에서 question title 선택할 경우 questionNum으로 question하나 찾아서 보여줌
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public ModelAndView selectMypageQuestion(HttpServletRequest request, HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		
		ModelAndView mav = new ModelAndView();
		
		if(user == null) {
			mav.setViewName("main");
		}
		else {
			int sessionmNum = user.getM_num();
		
			List<Question> selectQuestionBymNum = questionService.selectQuestionBymNum(sessionmNum);
		
			mav.addObject("selectQuestionBymNum", selectQuestionBymNum);
			mav.addObject("url", "question");
			mav.setViewName("user/mypage/mypage_main");
		}
		return mav;
	}
}
