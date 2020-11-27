package com.example.pet.comment;

import org.springframework.web.multipart.MultipartFile;

public class PetSitterComment {
	private int m_num;
	private int age;
	private int careNum;
	private String pictureUrl;
	private MultipartFile picture;
	
	public PetSitterComment() {  }

	public PetSitterComment(int m_num, int age, int careNum, MultipartFile picture) {
		super();
		this.m_num = m_num;
		this.age = age;
		this.careNum = careNum;
		this.picture = picture;
	}

	public int getM_num() { return m_num; }
	public void setM_num(int m_num) { this.m_num = m_num; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

	public int getCareNum() { return careNum; }
	public void setCareNum(int careNum) { this.careNum = careNum; }

	public String getPictureUrl() { return pictureUrl; }
	public void setPictureUrl(String pictureUrl) { this.pictureUrl = pictureUrl; }

	public MultipartFile getPicture() { return picture; }
	public void setPicture(MultipartFile picture) { this.picture = picture; }

	@Override
	public String toString() {
		return "PetSitter [m_num=" + m_num + ", age=" + age + ", careNum=" + careNum + ", picture=" + picture.getOriginalFilename() + "]";
	}
}
