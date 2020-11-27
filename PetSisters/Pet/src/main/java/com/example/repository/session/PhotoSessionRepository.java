package com.example.repository.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.pet.domain.Photo;
import com.example.repository.mapper.PhotoMapper;

public class PhotoSessionRepository {
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
	
	//모든 Photo 찾기
	public List<Photo> selectAllPhoto() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(PhotoMapper.class).selectAllPhoto();
		} finally {
			sqlSession.close();
		}
	}

	// uNum에 대한 Photo 찾기
	public List<Photo> selectPhotoByuNum(int uNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(PhotoMapper.class).selectPhotoByuNum(uNum);
		} finally {
			sqlSession.close();
		}
	}

	// 추가된 photo_num 찾기
	public List<Integer> selectPhotoNum() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(PhotoMapper.class).selectPhotoNum();
		} finally {
			sqlSession.close();
		}
	}

	// Photo 추가
	public int insertPhoto(Photo photo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(PhotoMapper.class).insertPhoto(photo);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Photo 수정
	public int updatePhoto(Photo photo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(PhotoMapper.class).updatePhoto(photo);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Photo 삭제
	public int deletePhoto(int photoNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(PhotoMapper.class).deletePhoto(photoNum);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
