package com.example.repository.session;

import java.io.*;
import java.util.*;

import com.example.pet.domain.Question;
import com.example.repository.mapper.QuestionMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class QuestionSessionRepository {
	private SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
	
	private SqlSessionFactory createSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	
	//모든 Question 찾기
	public List<Question> selectAllQuestion() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(QuestionMapper.class).selectAllQuestion();
		} finally {
			sqlSession.close();
		}
	}
	
	//findValue로 Question 찾기
	public List<Question> selectQuestionByFindValue(String findValue, String findValue2, String findValue3) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(QuestionMapper.class).selectQuestionByFindValue(findValue);
		} finally {
			sqlSession.close();
		}
	}
	
	//question_num으로 Question 찾기
	public Question selectQuestionByNum(int questionNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(QuestionMapper.class).selectQuestionByNum(questionNum);
		} finally {
			sqlSession.close();
		}
	}
		
	//m_type으로 Question 찾기
	public List<Question> selectQuestionByMType(String mType) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(QuestionMapper.class).selectQuestionByMType(mType);
		} finally {
			sqlSession.close();
		}
	}
	
	//추가된 question_num 찾기
	public List<Integer> selectQuestionNum() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(QuestionMapper.class).selectQuestionNum();
		} finally {
			sqlSession.close();
		}
	}
	
	//m_num으로 Question 찾기
	public List<Question> selectQuestionBymNum(int mNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(QuestionMapper.class).selectQuestionBymNum(mNum);
		} finally {
			sqlSession.close();
		}
	}
	
	  

	// Question 추가
	public int insertQuestion(Question question) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(QuestionMapper.class).insertQuestion(question);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Question 수정
	public int updateQuestion(Question question) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(QuestionMapper.class).updateQuestion(question);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	// Question hits ++ 수정
	public int updateQuestionHits(int questionNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(QuestionMapper.class).updateQuestionHits(questionNum);
				
			if (result > 0)
				sqlSession.commit();
				
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Question 삭제
	public int deleteQuestion(int questionNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			int result = sqlSession.getMapper(QuestionMapper.class).deleteQuestion(questionNum);

			if (result > 0)
				sqlSession.commit();

			return result;
		} finally {
			sqlSession.close();
		}
	}
}
