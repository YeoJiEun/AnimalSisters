package com.example.pet.domain;
import java.io.Serializable;

@SuppressWarnings("serial")
public class GoodsType implements Serializable {
	private int gNum;
	private String gType;
	
	public GoodsType() {
		super();
	}

	public GoodsType(int gNum, String gType) {
		super();
		this.gNum = gNum;
		this.gType = gType;
	}

	public int getgNum() { return gNum; }
	public void setgNum(int gNum) { this.gNum = gNum; }

	public String getgType() { return gType; }
	public void setgType(String gType) { this.gType = gType; }

	@Override
	public String toString() {
		return "GoodsType [gNum=" + gNum + ", gType=" + gType + "]";
	}
}
