package com.example.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dao.PhotoDAO;
import com.example.pet.domain.Photo;

@Service
public class PhotoService {

	@Autowired
	private PhotoDAO photoDAO;
	
	//모든 Photo 찾기
	public List<Photo> selectAllPhoto() {
		return photoDAO.selectAllPhoto();
	}
	
	// uNum에 대한 Photo 찾기
	public List<Photo> selectPhotoByuNum(int uNum) {
		return photoDAO.selectPhotoByuNum(uNum);
	}

	// 추가된 photo_num 찾기
	public List<Integer> selectPhotoNum() {
		return photoDAO.selectPhotoNum();
	}

	// Photo 추가
	public void insertPhoto(Photo photo) {
		photoDAO.insertPhoto(photo);
	}

	// Photo 수정
	public void updatePhoto(Photo photo) {
		photoDAO.updatePhoto(photo);
	}

	// Photo 삭제
	public void deletePhoto(int photoNum) {
		photoDAO.deletePhoto(photoNum);
	}
}
