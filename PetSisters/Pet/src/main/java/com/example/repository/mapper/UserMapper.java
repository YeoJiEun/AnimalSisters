package com.example.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.pet.domain.PetSitter;
import com.example.pet.domain.User;

public interface UserMapper {

	// id로 회원정보 찾기
	public User selectUser(@Param("id")String id, @Param("pw")String pw);
	
	//회원가입
	public int insertUser(User user);
	
	//회원정보 수정
	public int updateUser(User user);
	
	//회원정보 삭제
	public int deleteUser(int m_num);

	//펫시터 찾기
	public PetSitter selectPetSitter(int m_num);

	//펫시터 등록
	public int insertPetSitter(PetSitter petSitter);

	//펫시터 수정
	public int updatePetSitter(PetSitter petSitter);
	
	//펫시터 삭제
	public int deletePetSitter(int m_num);
	
	//펫시터 careNum 증가
	public int updateCareNum(int m_num);
	
	public List<PetSitter> selectAllPetSitter();
}
