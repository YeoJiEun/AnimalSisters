package com.example.pet.controller.question;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pet.domain.Question;
import com.example.pet.domain.User;
import com.example.pet.service.QuestionService;

@Controller
@RequestMapping("/question/*")
public class InsertQuestionController {

	@Inject
	QuestionService questionService;
	
	//Question 등록
	@RequestMapping("insertQuestion.do")
	public String insertQuestion(HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("**************insertQuestion***************");
		String path = "";
		
		//1. session에 있는 member 객체 set해 놓기 ->  m_num, m_type get해서 변수에 저장
		User user = (User) session.getAttribute("user");

		if(user != null) {
			int mNum = user.getM_num();	
			String mType = String.valueOf(user.getM_type());	
		
			//2. insert 할 questionNum 구하기
			int questionNum = 0;
			for(int val : questionService.selectQuestionNum())
				questionNum = val;	
			questionNum += 1;
		
			//3. Question 객체 insert하기
			Question question = new Question(questionNum, mNum, request.getParameter("question_title"), 
													request.getParameter("question_content"), mType);
			questionService.insertQuestion(question);
		
			//4. insert한 Question객체(+ User객체) 찾아오기
			Question questionByNum = questionService.selectQuestionByNum(questionNum);
		
			request.setAttribute("questionByNumOrInsert", questionByNum);
		
			path = "redirect:/question/qnum/" + questionNum;
		}
		else {
			path = "redirect:/question/main.do/insertFailed";
		}
		
		return path;
	}
}
