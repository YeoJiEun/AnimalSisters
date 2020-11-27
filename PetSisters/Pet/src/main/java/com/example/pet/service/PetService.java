package com.example.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dao.PetDAO;
import com.example.pet.domain.Pet;

@Service
public class PetService {
	@Autowired
	private PetDAO PetDAO;
	
	//회원 한명의 정보를 가져다주는 
    public Pet getPetInfo(int m_num){
        return PetDAO.selectPet(m_num);
    }
    public int insertPet(Pet pet) {
    	return PetDAO.insertPet(pet);
    }
	public int updatePet(Pet pet) {
		return PetDAO.updatePet(pet);
	}
	public int deletePet(int id) {
		return PetDAO.deletePet(id);
	}
}
