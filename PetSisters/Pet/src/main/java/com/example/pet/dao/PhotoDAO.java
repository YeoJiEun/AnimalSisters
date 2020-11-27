package com.example.pet.dao;

import java.util.List;

import com.example.pet.domain.Photo;

public interface PhotoDAO {
	//모든 Photo 찾기
	public List<Photo> selectAllPhoto();
	
	//uNum에 대한 Photo 찾기
	public List<Photo> selectPhotoByuNum(int uNum);
	
	//추가된 photo_num 찾기
	public List<Integer> selectPhotoNum();
	
	//Photo 추가
	public void insertPhoto(Photo photo);
		
	//Photo 수정
	public void updatePhoto(Photo photo);
			
	//Photo 삭제
	public void deletePhoto(int photoNum);
}
