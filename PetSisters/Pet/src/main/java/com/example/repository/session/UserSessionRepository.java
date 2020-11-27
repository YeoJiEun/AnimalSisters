package com.example.repository.session;

import java.io.*;

import com.example.pet.domain.User;
import com.example.repository.mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class UserSessionRepository {
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
	
	//id로 회원찾기
	public User selectUser(String id, String pw) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UserMapper.class).selectUser(id, pw);
		} finally {
			sqlSession.close();
		}
	}
}
