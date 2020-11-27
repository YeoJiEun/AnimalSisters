package com.example.repository.mapper;

import java.util.List;

import com.example.pet.domain.Photo;

public interface PhotoMapper {
	//모든 Photo 찾기
	public List<Photo> selectAllPhoto();
	
	// uNum에 대한 Photo 찾기
	public List<Photo> selectPhotoByuNum(int uNum);

	// 추가된 photo_num 찾기
	public List<Integer> selectPhotoNum();

	// Photo 추가
	public int insertPhoto(Photo photo);

	// Photo 수정
	public int updatePhoto(Photo photo);

	// Photo 삭제
	public int deletePhoto(int photoNum);
}
