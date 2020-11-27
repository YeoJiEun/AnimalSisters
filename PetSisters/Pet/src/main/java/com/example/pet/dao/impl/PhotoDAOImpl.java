package com.example.pet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.PhotoDAO;
import com.example.pet.domain.Photo;
import com.example.repository.mapper.PhotoMapper;

@Repository
public class PhotoDAOImpl implements PhotoDAO{

	@Autowired
	private PhotoMapper photoMapper;
	
	//모든 Photo 찾기
	@Override
	public List<Photo> selectAllPhoto() {
		return photoMapper.selectAllPhoto();
	}
	
	// uNum에 대한 Photo 찾기
	@Override
	public List<Photo> selectPhotoByuNum(int uNum) {
		return photoMapper.selectPhotoByuNum(uNum);
	}

	// 추가된 photo_num 찾기
	@Override
	public List<Integer> selectPhotoNum() {
		return photoMapper.selectPhotoNum();
	}

	// Photo 추가
	@Override
	public void insertPhoto(Photo photo) {
		int result = photoMapper.insertPhoto(photo);
		if (result == 1)
			System.out.println("-----Insert Photo Success-----");	
	}

	// Photo 수정
	@Override
	public void updatePhoto(Photo photo) {
		int result = photoMapper.updatePhoto(photo);
		if (result == 1)
			System.out.println("-----Update Photo Success-----");	
	}

	// Photo 삭제
	@Override
	public void deletePhoto(int photoNum) {
		int result = photoMapper.deletePhoto(photoNum);
		if (result == 1)
			System.out.println("-----Delete Photo Success-----");	
	}
}
