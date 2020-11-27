package com.example.pet.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Photo implements Serializable {
	private int photoNum;
	private int uNum;
	private String photoPath;
	
	public Photo() { super(); }

	public Photo(int photoNum, int uNum, String photoPath) {
		super();
		this.photoNum = photoNum;
		this.uNum = uNum;
		this.photoPath = photoPath;
	}

	public int getPhotoNum() { return photoNum; }
	public void setPhotoNum(int photoNum) { this.photoNum = photoNum; }

	public int getuNum() { return uNum; }
	public void setuNum(int uNum) { this.uNum = uNum; }

	public String getPhotoPath() { return photoPath; }
	public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

	@Override
	public String toString() {
		return "Photo [photoNum=" + photoNum + ", uNum=" + uNum + ", photoPath=" + photoPath + "]";
	}
}
