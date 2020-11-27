package com.example.pet.controller.question;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Question;
import com.example.pet.domain.User;
import com.example.pet.service.QuestionService;

@Controller
@RequestMapping("/question/*")
public class UpdateQuestionController {
	
	@Inject
	QuestionService questionService;
	
	// Question 상세정보에서 수정 버튼을 누를 경우 실행
	@RequestMapping("/update/{questionNum}")
	public String updateQuestion(@PathVariable int questionNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************updateQuestion***************");

		// 1. questionNum 받기
		
		// 2. questionNum으로 selectQuestionByNum하기, mNum을 변수로 저장
		Question questionByNum = questionService.selectQuestionByNum(questionNum);
		int questionmNum = questionByNum.getmNum();

		// 3.session에 있는 member 객체 set해 놓기 -> m_num, m_type get해서 변수에 저장
		User user = (User) session.getAttribute("user");
		int sessionmNum = user.getM_num();	
		String mType = String.valueOf(user.getM_type());
		
		// 4 - 1. mType이 0번이면 관리자라는 의미 -> 관리자는 수정 가능
		// 4 - 2. mType이 1이나 2면, session에 있는 member 객체의 m_num과 변수 mNum 비교하기
		// 4 - 3. 같으면 updateForm.jsp로 , 다르면 redirection...
		String path = "";
		
		if(mType.equals("0")) {
			System.out.println("************** 관리자, 수정함***************");
			request.setAttribute("question", questionByNum);
			path = "question/updateForm";
		}
		else {
			if(questionmNum != sessionmNum) {
				System.out.println("************** 넘 다름 수정 X***************");
				request.setAttribute("questionByNumOrInsert", questionByNum);
				request.setAttribute("updateFailed", "true");
				path = "question/question_detail";
			}
			else {
				System.out.println("************** 넘 같음 수정***************");
				request.setAttribute("question", questionByNum);
				path = "question/updateForm";
			}
		}
		
		return path; 
	}
	
	//Question 수정
	@RequestMapping("updateQuestion.do/{questionNum}")
	public ModelAndView insertQuestion(@PathVariable int questionNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************updateQuestion***************");

		//1.session에 있는 member 객체 set해 놓기 ->  m_num, m_type get해서 변수에 저장	
		User user = (User) session.getAttribute("user");
		int mNum = user.getM_num();	
		String mType = String.valueOf(user.getM_type());
		
		//2. update 할 questionNum 찾기

		//3. Question update
		Question question = new Question(questionNum, mNum, request.getParameter("question_title"), 
													request.getParameter("question_content"), mType);
		questionService.updateQuestion(question);

		Question questionByNum = questionService.selectQuestionByNum(questionNum);
		
		//4. question_detail.jsp로 수정된 question 정보 보내기
		ModelAndView mav = new ModelAndView();
			
		mav.setViewName("question/question_detail");	//뷰를 question_detail.jsp로 설정
		mav.addObject("questionByNumOrInsert", questionByNum);	//데이터를 저장
			
		return mav;
	}
}
