package com.example.repository.mapper;

import com.example.pet.domain.Pet;

public interface PetMapper {
	Pet selectPet(int m_num);
	int insertPet(Pet pet);
	int updatePet(Pet pet);	
	int deletePet(int m_num);
}