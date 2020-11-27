package com.example.pet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pet.dao.MemberDAO;
import com.example.pet.dao.ReservationDao;
import com.example.pet.domain.Reservation;

@Service
public class ReservationService {
	@Autowired
	private ReservationDao ReservationRepository;
	@Autowired
	private MemberDAO memberDAO;

	//모든 Reservation 찾기
	public Reservation selectReservation(@Param("b_num")int b_num, @Param("b_num")int m_num, @Param("r_date") String r_date) {
		return ReservationRepository.selectReservation(b_num, m_num, r_date);
	}
			
	//findValue로 Reservation 찾기
	public List<Reservation> selectReservationByFindValue(String findValue) {
		return ReservationRepository.selectReservationByFindValue(findValue);
	}
		
	//Reservation_num으로 Reservation 찾기
	public List<Reservation> selectReservationByNum(int ReservationNum) {
		return ReservationRepository.selectReservationByNum(ReservationNum);
	}
			
	public List<Reservation> selectReservationBySitterNum(int ReservationNum) {
		System.out.println("****service :num = "+ReservationNum );
		return ReservationRepository.selectReservationBySitterNum(ReservationNum);
		
	}
		
	//m_type으로 Reservation 찾기
	public List<Reservation> selectReservationByMType(String mType) {
		return ReservationRepository.selectReservationByMType(mType);
	}

	public int findSitter(int b_num) {
		return ReservationRepository.findSitter(b_num);
	}
			
	//Reservation 추가
	@Transactional
	public Integer insertReservation(Reservation Reservation) {
		return ReservationRepository.insertReservation(Reservation);
	}
			
	//Reservation 수정
	@Transactional
	public Integer updateReservation(Reservation Reservation) {
		return ReservationRepository.updateReservation(Reservation);
	}
			
	//Reservation 삭제
	public Integer deleteReservation(@Param("b_num") int b_num, @Param("m_num") int m_num, @Param("r_date") String r_date) {
		return ReservationRepository.deleteReservation(b_num,m_num,r_date);
	}
	
	//Sitter_careNum 수정
	public void updateCareNum(int m_num) {
		memberDAO.updateCareNum(m_num);
	}
}
