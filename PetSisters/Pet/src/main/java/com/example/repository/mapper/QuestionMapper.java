package com.example.repository.mapper;

import java.util.List;

import com.example.pet.domain.Question;

public interface QuestionMapper {

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
	public int insertQuestion(Question question);
		
	//Question 수정
	public int updateQuestion(Question question);
	
	//Question hits ++
	public int updateQuestionHits(int questionNum);	
		
	//Question 삭제
	public int deleteQuestion(int questionNum);
}
