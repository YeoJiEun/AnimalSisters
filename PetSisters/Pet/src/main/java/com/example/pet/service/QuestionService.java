package com.example.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pet.dao.QuestionDAO;
import com.example.pet.domain.Question;

@Service
public class QuestionService {
	@Autowired
	private QuestionDAO questionDAO;

	//모든 Question 찾기
	public List<Question> selectAllQuestion() {
		return questionDAO.selectAllQuestion();
	}
			
	//findValue로 Question 찾기
	public List<Question> selectQuestionByFindValue(String findValue) {
		return questionDAO.selectQuestionByFindValue(findValue);
	}
		
	//question_num으로 Question 찾기
	public Question selectQuestionByNum(int questionNum) {
		return questionDAO.selectQuestionByNum(questionNum);
	}
			
	//m_type으로 Question 찾기
	public List<Question> selectQuestionByMType(String mType) {
		return questionDAO.selectQuestionByMType(mType);
	}
	
	//추가된 question_num 찾기
	public List<Integer> selectQuestionNum() {
		return questionDAO.selectQuestionNum();
	}
	
	//m_num으로 Question 찾기
	public List<Question> selectQuestionBymNum(int mNum) {
		return questionDAO.selectQuestionBymNum(mNum);
	}
			
			
	//Question 추가
	@Transactional
	public void insertQuestion(Question question) {
		questionDAO.insertQuestion(question);
	}
			
	//Question 수정
	public void updateQuestion(Question question) {
		questionDAO.updateQuestion(question);
	}
	
	//Question hits ++
	public void updateQuestionHits(int questionNum) {
		questionDAO.updateQuestionHits(questionNum);
	}
			
	//Question 삭제
	public void deleteQuestion(int questionNum) {
		questionDAO.deleteQuestion(questionNum);
	}
}
