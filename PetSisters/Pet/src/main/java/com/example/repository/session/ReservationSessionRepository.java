package com.example.repository.session;

import java.io.*;
import java.util.*;

import com.example.pet.domain.Reservation;
import com.example.repository.mapper.ReservationMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class ReservationSessionRepository {
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

	
	//모든 Reservation 찾기
	public Reservation selectReservation(int b_num,int m_num, String r_date) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(ReservationMapper.class).selectReservation(b_num, m_num,r_date);
		} finally {
			sqlSession.close();
		}
	}
	
	//findValue로 Reservation 찾기
	public List<Reservation> selectReservationByFindValue(String findValue) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(ReservationMapper.class).selectReservationByFindValue(findValue);
		} finally {
			sqlSession.close();
		}
	}
	
	//reservation_num으로 Reservation 찾기
	public List<Reservation> selectReservationByNum(int reservationNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(ReservationMapper.class).selectReservationByNum(reservationNum);
		} finally {
			sqlSession.close();
		}
	}
	//reservation_num으로 Reservation 찾기
		public List<Reservation> selectReservationBySitterNum(int reservationNum) {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			try {
				return sqlSession.getMapper(ReservationMapper.class).selectReservationBySitterNum(reservationNum);
			} finally {
				sqlSession.close();
			}
		}
		
	//m_type으로 Reservation 찾기
	public List<Reservation> selectReservationByMType(String mType) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(ReservationMapper.class).selectReservationByMType(mType);
		} finally {
			sqlSession.close();
		}
	}
	
	  

	// Reservation 추가
	public Integer insertReservation(Reservation reservation) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(ReservationMapper.class).insertReservation(reservation);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Reservation 수정
	public Integer updateReservation(Reservation reservation) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(ReservationMapper.class).updateReservation(reservation);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	// Reservation 삭제
	public Integer deleteReservation(int reservationNum,int b_num,String date) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			int result = sqlSession.getMapper(ReservationMapper.class).deleteReservation(reservationNum, b_num, date);

			if (result > 0)
				sqlSession.commit();

			return result;
		} finally {
			sqlSession.close();
		}
	}
}
