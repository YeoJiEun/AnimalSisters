package com.example.pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.pet.domain.Reservation;

public interface ReservationDao {
	// 모든 Reservation 찾기
	List<Reservation> selectAllReservation();

	// findValue로 Reservation 찾기
	List<Reservation> selectReservationByFindValue(String findValue);

	// Reservation_num으로 Reservation 찾기
	List<Reservation> selectReservationByNum(int ReservationNum);

	List<Reservation> selectReservationBySitterNum(int ReservationNum);

	// m_type으로 Reservation 찾기
	List<Reservation> selectReservationByMType(String mType);

	// Reservation 추가
	Integer insertReservation(Reservation Reservation);

	// Reservation 수정
	Integer updateReservation(Reservation Reservation);

	// Reservation 삭제
	Integer deleteReservation(@Param("b_num") int b_num, @Param("m_num") int m_num, @Param("r_date") String r_date);

	int findSitter(int b_num);

	Reservation selectReservation(@Param("b_num") int b_num, @Param("m_num") int m_num, @Param("r_date") String r_date);
}
