package com.example.pet.dao;

import java.util.List;

import com.example.pet.domain.PetSitter;
import com.example.pet.domain.User;

public interface MemberDAO {
	
	// id로 회원정보 찾기
	public User selectUser(String id, String pw);
		
	//회원가입
	public void insertUser(User user);
		
	//회원정보 수정
	public void updateUser(User user);
	
	//회원정보 삭제
	public void deleteUser(int m_num);

	//펫시터 찾기
	public PetSitter selectPetSitter(int m_num);
	
	//펫시터 등록
	public void insertPetSitter(PetSitter petSitter);
		
	//펫시터 수정
	public void updatePetSitter(PetSitter petSitter);
	
	//펫시터 삭제
	public void deletePetSitter(int m_num);
	
	//펫시터 careNum 증가
	public void updateCareNum(int m_num);

	public List<PetSitter> selectAllPetSitter();
}