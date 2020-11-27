package com.example.repository.session;

import java.io.*;
import java.util.*;

import com.example.pet.domain.Basket;
import com.example.pet.domain.Board;
import com.example.repository.mapper.BasketMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class BasketSessionRepository {
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

	
	//모든 Basket 찾기
	public List<Basket> selectAllBasket(int m_num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BasketMapper.class).selectAllBasket(m_num);
		} finally {
			sqlSession.close();
		}
	}
	
	//findValue로 Basket 찾기
	public List<Basket> selectBasketByFindValue(String findValue) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BasketMapper.class).selectBasketByFindValue(findValue);
		} finally {
			sqlSession.close();
		}
	}
	
	//basket_num으로 Basket 찾기
	public List<Board> selectBasketByNum(int basketNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BasketMapper.class).selectBasketByNum(basketNum);
		} finally {
			sqlSession.close();
		}
	}
		
	//m_type으로 Basket 찾기
	public List<Basket> selectBasketByMType(String mType) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(BasketMapper.class).selectBasketByMType(mType);
		} finally {
			sqlSession.close();
		}
	}
	
	  

	// Basket 추가
	public Integer insertBasket(Basket basket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(BasketMapper.class).insertBasket(basket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Basket 수정
	public Integer updateBasket(Basket basket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(BasketMapper.class).updateBasket(basket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Basket 삭제
	public Integer deleteBasket(int basketNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			int result = sqlSession.getMapper(BasketMapper.class).deleteBasket(basketNum);

			if (result > 0)
				sqlSession.commit();

			return result;
		} finally {
			sqlSession.close();
		}
	}
}
