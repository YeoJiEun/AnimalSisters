package com.example.pet.domain;

public class Schedule {
	private int s_num;
	private int m_num;
	private String s_date;
	
	public Schedule() {  }
	
	public Schedule(int m_num, String s_date) {
		super();
		this.m_num = m_num;
		this.s_date = s_date;
	}
	public Schedule(int s_num, int m_num, String s_date) {
	
		this.s_num = s_num;
		this.m_num = m_num;
		this.s_date = s_date;
	}
	
	public int getS_num() { return s_num; }	
	public void setS_num(int s_num) { this.s_num = s_num; }
	
	public int getM_num() { return m_num; }	
	public void setM_num(int m_num) { this.m_num = m_num; }
	
	public String getS_date() { return s_date; }	
	public void setS_date(String s_date) { this.s_date = s_date; }
	
	@Override
	public String toString() {
		return "Schedule [s_num=" + s_num + ", m_num=" + m_num + ", s_date=" + s_date + "]";
	}	
}
