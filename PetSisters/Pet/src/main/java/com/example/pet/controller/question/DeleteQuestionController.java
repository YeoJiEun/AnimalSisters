package com.example.pet.controller.question;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pet.domain.Question;
import com.example.pet.domain.User;
import com.example.pet.service.QuestionService;

@Controller
@RequestMapping("/question/*")
public class DeleteQuestionController {

	@Inject
	QuestionService questionService;

	// Question 상세정보에서 삭제 버튼을 누를 경우 실행
	@RequestMapping("/delete/{questionNum}")
	public String deleteQuestion(@PathVariable int questionNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************deleteQuestion***************");

		// 1. questionNum 받기
		
		// 2. questionNum으로 selectQuestionByNum하기, mNum을 변수로 저장
		Question questionByNum = questionService.selectQuestionByNum(questionNum);
		int questionmNum = questionByNum.getmNum();

		// 3.session에 있는 member 객체 set해 놓기 -> m_num, m_type get해서 변수에 저장
		User user = (User) session.getAttribute("user");
		int sessionmNum = user.getM_num();	
		String mType = String.valueOf(user.getM_type());	

		// 4 - 1. mType이 0번이면 관리자라는 의미 -> 관리자는 삭제 가능
		// 4 - 2. mType이 1이나 2면, session에 있는 member 객체의 m_num과 변수 mNum 비교하기
		// 4 - 3. 같으면 deleteQuestion, 다르면 redirection...
		String path = "";
		
		if(mType.equals("0")) {
			questionService.deleteQuestion(questionNum);
			System.out.println("************** 관리자, 삭제함***************");
			path = "redirect:/question/main.do/main";
		}
		else {
			if(questionmNum != sessionmNum) {
				System.out.println("************** 넘 다름 안삭제***************");
				request.setAttribute("questionByNumOrInsert", questionByNum);
				request.setAttribute("deleteFailed", "true");
				path = "question/question_detail";
			}
			else {
				questionService.deleteQuestion(questionNum);
				System.out.println("************** 넘 같음 삭제***************");
				path = "redirect:/question/main.do/main";
			}
		}
		
		return path; 
	}
}
