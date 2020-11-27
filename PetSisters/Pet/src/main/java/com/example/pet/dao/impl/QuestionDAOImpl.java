package com.example.pet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.QuestionDAO;
import com.example.pet.domain.Question;
import com.example.repository.mapper.QuestionMapper;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
	@Autowired
	private QuestionMapper questionMapper;
	
	//모든 Question 찾기
	@Override
	public List<Question> selectAllQuestion() {
		return questionMapper.selectAllQuestion();
	}
	
	//findValue로 Question 찾기
	@Override
	public List<Question> selectQuestionByFindValue(String findValue) {
		return questionMapper.selectQuestionByFindValue(findValue);
	}
	
	//question_num으로 Question 찾기
	@Override
	public Question selectQuestionByNum(int questionNum) {
		return questionMapper.selectQuestionByNum(questionNum);
	}
		
	//m_type으로 Question 찾기
	@Override
	public List<Question> selectQuestionByMType(String mType) {
		return questionMapper.selectQuestionByMType(mType);
	}
	
	//추가된 question_num
	@Override
	public List<Integer> selectQuestionNum() {
		return questionMapper.selectQuestionNum();
	}
	
	//m_num으로 Question 찾기
	@Override
	public List<Question> selectQuestionBymNum(int mNum) {
		return questionMapper.selectQuestionBymNum(mNum);
	}
		
	
	
	//Question 추가
	@Override
	public void insertQuestion(Question question) {
		Integer result = questionMapper.insertQuestion(question);
		if (result == 1)
			System.out.println("-----Insert Question Success-----");	
	}
	
	//Question hits ++
	@Override
	public void updateQuestionHits(int questionNum) {
		Integer result = questionMapper.updateQuestionHits(questionNum);
		if (result == 1)
			System.out.println("-----Update Question Hits Success-----");	
	}
	
	//Question 수정
	@Override
	public void updateQuestion(Question question) {
		Integer result = questionMapper.updateQuestion(question);
		if (result == 1)
			System.out.println("-----Update Question Success-----");	
	}
		
	//Question 삭제
	@Override
	public void deleteQuestion(int questionNum) {
		int result = questionMapper.deleteQuestion(questionNum);
		if (result == 1)
			System.out.println("-----Delete Question Success-----");	
	}
}
