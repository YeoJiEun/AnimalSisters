package com.example.repository.session;

import java.io.*;
import java.util.*;

import com.example.pet.domain.Board;
import com.example.repository.mapper.BoardMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class BoardSessionRepository {
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

	
	//모든 Board 찾기
	public List<Board> selectAllBoard() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BoardMapper.class).selectAllBoard();
		} finally {
			sqlSession.close();
		}
	}
	/*
	//findValue로 Board 찾기
	public List<Board> selectBoardByFindValue(String findValue) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BoardMapper.class).selectBoardByFindValue(findValue);
		} finally {
			sqlSession.close();
		}
	}
	*/
	//Board_num으로 Board 찾기
	public Board selectBoardByNum(int BoardNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BoardMapper.class).selectBoardByNum(BoardNum);
		} finally {
			sqlSession.close();
		}
	}

	// Board 삭제
	public Integer deleteBoard(int b_num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			int result = sqlSession.getMapper(BoardMapper.class).deleteBoard(b_num);

			if (result > 0)
				sqlSession.commit();

			return result;
		} finally {
			sqlSession.close();
		}
	}

	//m_type으로 Board 찾기
	public List<Board> selectBoardByMType(String mType) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BoardMapper.class).selectBoardByMType(mType);
		} finally {
			sqlSession.close();
		}
	}
	
	// Board 추가
	public Integer insertBoard(Board Board) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(BoardMapper.class).insertBoard(Board);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Board 수정
	public Integer updateBoard(Board Board) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(BoardMapper.class).updateBoard(Board);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
