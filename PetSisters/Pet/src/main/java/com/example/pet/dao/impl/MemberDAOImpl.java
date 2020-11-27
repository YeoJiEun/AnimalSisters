package com.example.pet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.MemberDAO;
import com.example.pet.domain.PetSitter;
import com.example.pet.domain.User;
import com.example.repository.mapper.UserMapper;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectUser(String id, String pw) {
		return userMapper.selectUser(id, pw);
	}

	@Override
	public void insertUser(User user) {
		int result = userMapper.insertUser(user);
		
		if (result == 1)
			System.out.println("-----Insert User Success-----");
	}

	@Override
	public void updateUser(User user) {
		int result = userMapper.updateUser(user);
		
		if (result == 1)
			System.out.println("-----Update User Success-----");
	}

	@Override
	public void deleteUser(int m_num) {
		int result = userMapper.deleteUser(m_num);
		
		if (result == 1)
			System.out.println("-----Delete User Success-----");
	}

	@Override
	public PetSitter selectPetSitter(int m_num) {
		System.out.println("-----Select PetSitter Success-----");
		return userMapper.selectPetSitter(m_num);	
	}

	@Override
	public void insertPetSitter(PetSitter petSitter) {
		int result = userMapper.insertPetSitter(petSitter);
		
		if (result == 1)
			System.out.println("-----Insert PetSitter Success-----");	
	}

	@Override
	public void updatePetSitter(PetSitter petSitter) {
		int result = userMapper.updatePetSitter(petSitter);
		
		if (result == 1)
			System.out.println("-----Update PetSitter Success-----");	
	}

	@Override
	public void deletePetSitter(int m_num) {
		int result = userMapper.deletePetSitter(m_num);
		
		if (result == 1)
			System.out.println("-----Delete PetSitter Success-----");	
	}

	@Override
	public void updateCareNum(int m_num) {
		int result = userMapper.updateCareNum(m_num);
		
		if (result == 1)
			System.out.println("-----Update PetSitter CareNum Success-----");
		else
			System.out.println("-----Update PetSitter CareNum Fail-----");
	}
	
	@Override
	public List<PetSitter> selectAllPetSitter() {
		return userMapper.selectAllPetSitter();
	}
}
