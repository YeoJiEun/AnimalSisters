package com.example.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.pet.domain.Reservation;

public interface ReservationMapper {

	//모든 Reservation 찾기
	List<Reservation> selectAllReservation();
		
	//findValue로 Reservation 찾기
	List<Reservation> selectReservationByFindValue(String findValue);
	
	//Reservation_num으로 Reservation 찾기
	List<Reservation> selectReservationByNum(int ReservationNum);
		
	List<Reservation> selectReservationBySitterNum(int ReservationNum);
	//m_type으로 Reservation 찾기
	List<Reservation> selectReservationByMType(String mType);
		
		
	//Reservation 추가
	int insertReservation(Reservation Reservation);
		
	//Reservation 수정
	int updateReservation(Reservation Reservation);
		
	//Reservation 삭제
	int deleteReservation(@Param("b_num") int b_num, @Param("m_num") int m_num, @Param("r_date") String r_date);

	int findSitter(int b_num);

	Reservation selectReservation(@Param("b_num")int b_num, @Param("m_num")int m_num, @Param("r_date") String r_date);
}
