package com.example.pet.domain;

@SuppressWarnings("serial")
public class PetSitter extends User {
	private int m_num;
	private int age;
	private int careNum;
	private String picture;
	
	public PetSitter() {  }
	
	public PetSitter(int m_num) {
		super();
		this.m_num = m_num;
	}

	public PetSitter(int m_num, int age, int careNum, String picture) {
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

	public String getPicture() { return picture; }
	public void setPicture(String picture) { this.picture = picture; }

	@Override
	public String toString() {
		return "PetSitter [m_num=" + m_num + ", age=" + age + ", careNum=" + careNum + ", picture=" + picture + "]";
	}
}
