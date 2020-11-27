package com.example.pet.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.ReservationDao;
import com.example.pet.domain.Reservation;
import com.example.repository.mapper.ReservationMapper;

@Repository
public class ReservationDAOImpl implements ReservationDao{
	@Autowired
	private ReservationMapper ReservationMapper;

	//모든 Reservation 찾기
	public List<Reservation> selectAllReservation() {
		return ReservationMapper.selectAllReservation();
	}
	
	//findValue로 Reservation 찾기
	public List<Reservation> selectReservationByFindValue(String findValue) {
		return ReservationMapper.selectReservationByFindValue(findValue);
	}
	
	//Reservation_num으로 Reservation 찾기
	public List<Reservation> selectReservationByNum(int ReservationNum) {
		return ReservationMapper.selectReservationByNum(ReservationNum);
	}
		
	//sitter_num으로 Reservation 찾기
	public List<Reservation> selectReservationBySitterNum(int ReservationNum) {	
		return ReservationMapper.selectReservationBySitterNum(ReservationNum);
	}
		
	//m_type으로 Reservation 찾기
	public List<Reservation> selectReservationByMType(String mType) {
		return ReservationMapper.selectReservationByMType(mType);
	}
		
		
	//Reservation 추가
	public Integer insertReservation(Reservation Reservation) {
		Integer result = ReservationMapper.insertReservation(Reservation);
		return result;
	}
		
	//Reservation 수정
	public Integer updateReservation(Reservation Reservation) {
		Integer result = ReservationMapper.updateReservation(Reservation);
		return result;
	}
		
	//Reservation 삭제
	public Integer deleteReservation(@Param("b_num") int b_num, @Param("m_num") int m_num, @Param("r_date") String r_date) {
		Integer result = ReservationMapper.deleteReservation(b_num, m_num,r_date);
		return result;
	}

	public int findSitter(int b_num) {
		int result = ReservationMapper.findSitter(b_num);
		return result;
	}

	public Reservation selectReservation(@Param("b_num")int b_num,@Param("m_num")int m_num, @Param("r_date") String r_date) {
		return ReservationMapper.selectReservation(b_num, m_num, r_date);
	}
}
