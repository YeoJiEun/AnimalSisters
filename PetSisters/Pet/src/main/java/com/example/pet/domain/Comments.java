package com.example.pet.domain;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Comments implements Serializable {
	private int cNum;
	private int mNum;
	private int crNum;
	private String cType;
	private String cContent;
	private Date cDate;
	private String mNickname;
	
	public Comments() {
		super();
	}
	
	public Comments(int cNum, String cContent) {
		this.cNum = cNum;
		this.cContent = cContent;
	}
	
	public Comments(int cNum, int mNum, int crNum, String cType, String cContent) {
		this.cNum = cNum;
		this.mNum = mNum;
		this.crNum = crNum;
		this.cType = cType;
		this.cContent = cContent;
	}

	public Comments(int cNum, int mNum, int crNum, String cType, String cContent, Date cDate, String mNickname) {
		super();
		this.cNum = cNum;
		this.mNum = mNum;
		this.crNum = crNum;
		this.cType = cType;
		this.cContent = cContent;
		this.cDate = cDate;
		this.mNickname = mNickname;
	}

	public int getcNum() { return cNum; }
	public void setcNum(int cNum) { this.cNum = cNum; }

	public int getmNum() { return mNum; }
	public void setmNum(int mNum) { this.mNum = mNum; }

	public int getCrNum() { return crNum; }
	public void setCrNum(int crNum) { this.crNum = crNum; }

	public String getcType() { return cType; }
	public void setcType(String cType) { this.cType = cType; }

	public String getcContent() { return cContent; }
	public void setcContent(String cContent) { this.cContent = cContent; }

	public Date getcDate() { return cDate; }
	public void setcDate(Date cDate) { this.cDate = cDate; }

	public String getmNickname() { return mNickname; }
	public void setmNickname(String mNickname) { this.mNickname = mNickname; }

	@Override
	public String toString() {
		return "COMMENTS [cNum=" + cNum + ", mNum=" + mNum + ", crNum=" + crNum + ", cType=" + cType + ", cContent="
				+ cContent + ", cDate=" + cDate + ", mNickname=" + mNickname + "]";
	}	
}
