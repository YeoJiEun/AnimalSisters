package com.example.repository.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.pet.domain.Comments;
import com.example.repository.mapper.CommentsMapper;

public class CommentsSessionRepository {
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
	
	//questionNum에 대한 모든 Question Comment 찾기 || uNum에 대한 모든 UsedMarket Comment 찾기
	@SuppressWarnings("rawtypes")
	public List<Comments> selectAllComment(HashMap map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(CommentsMapper.class).selectAllComment(map);
		} finally {
			sqlSession.close();
		}
	}
	
	//questionNum에 대한 Question Comment 찾기   ||  uNum에 대한 UsedMarket Comment 찾기
	public Comments selectCommentByNum(int cNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(CommentsMapper.class).selectCommentByNum(cNum);
		} finally {
			sqlSession.close();
		}
	}
	
	//추가된c_num 찾기
	public List<Integer> selectCommentNum() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
			
		try {
			return sqlSession.getMapper(CommentsMapper.class).selectCommentNum();
		} finally {
			sqlSession.close();
		}
	}

	// Comment 추가
	public int insertComment(Comments comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(CommentsMapper.class).insertComment(comment);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	// Comment 수정
	public int updateComment(Comments comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(CommentsMapper.class).updateComment(comment);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Comment 삭제
	public int deleteComment(int cNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(CommentsMapper.class).deleteComment(cNum);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
