package com.example.pet.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.PetDAO;
import com.example.pet.domain.Pet;
import com.example.repository.mapper.PetMapper;

@Repository
public class PetDAOImpl implements PetDAO {
	@Autowired
	private PetMapper petMapper;

	@Override
	public Pet selectPet(int m_num) {
		return petMapper.selectPet(m_num);
	}

	@Override
	public int insertPet(Pet pet) {
		Integer result = petMapper.insertPet(pet);
		return result;
	}

	@Override
	public int updatePet(Pet pet) {
		Integer result = petMapper.updatePet(pet);
		return result;
	}

	@Override
	public int deletePet(int m_num) {
		Integer result = petMapper.deletePet(m_num);
		return result;
	}
}
