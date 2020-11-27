package com.example.pet.dao;

import org.springframework.stereotype.Repository;

import com.example.pet.domain.Pet;

@Repository
public interface PetDAO {
	Pet selectPet(int m_num);
	int insertPet(Pet pet);
	int updatePet(Pet pet);	
	int deletePet(int m_num);
}