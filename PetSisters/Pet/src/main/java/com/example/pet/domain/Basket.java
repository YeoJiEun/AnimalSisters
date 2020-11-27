package com.example.pet.domain;

public class Basket {
	private int b_num;
	private int m_num;
	
	public Basket() {  }
	
	public Basket(int b_num, int m_num) {
		super();
		this.b_num = b_num;
		this.m_num = m_num;
	}
	
	public int getB_num() { return b_num; }
	public void setB_num(int b_num) { this.b_num = b_num; }
	
	public int getM_num() { return m_num; }	
	public void setM_num(int m_num) { this.m_num = m_num; }
	
	@Override
	public String toString() {
		return "BasketDTO [b_num=" + b_num + ", m_num=" + m_num + "]";
	}
}
