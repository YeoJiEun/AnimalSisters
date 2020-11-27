package com.example.pet.dao;

import java.util.List;

import com.example.pet.domain.Question;

public interface QuestionDAO {
	
	//모든 Question 찾기
	public List<Question> selectAllQuestion();
	
	//findValue로 Question 찾기
	public List<Question> selectQuestionByFindValue(String findValue);
	
	//question_num으로 Question 찾기
	public Question selectQuestionByNum(int questionNum);
	
	//m_type으로 Question 찾기
	public List<Question> selectQuestionByMType(String mType);
	
	//추가된 question_num
	public List<Integer> selectQuestionNum();
	
	//m_num으로 Question 찾기
	public List<Question> selectQuestionBymNum(int mNum);
	
	
	
	//Question 추가
	public void insertQuestion(Question question);
	
	//Question 수정
	public void updateQuestion(Question question);
	
	//Question hits ++
	public void updateQuestionHits(int questionNum);	
		
	//Question 삭제
	public void deleteQuestion(int questionNum);
}
