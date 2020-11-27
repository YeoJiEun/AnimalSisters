package com.example.pet.domain;

public class Point {	
	private int po_num;
	private int m_num;
	private int po_balance;
	private String po_log;
	private String po_date;
	
	public Point() {  }
	
	public Point(int m_num, int po_balance, String po_log, String po_date) {
		super();
		this.m_num = m_num;
		this.po_balance = po_balance;
		this.po_log = po_log;
		this.po_date = po_date;
	}
	
	public int getPo_num() { return po_num; }	
	public void setPo_num(int po_num) { this.po_num = po_num; }
	
	public int getM_num() { return m_num; }	
	public void setM_num(int m_num) { this.m_num = m_num; }
	
	public int getPo_balance() { return po_balance; }	
	public void setPo_balance(int po_balance) { this.po_balance = po_balance; }
	
	public String getPo_log() { return po_log; }
	public void setPo_log(String po_log) { this.po_log = po_log; }
	
	public String getPo_date() { return po_date; }	
	public void setPo_date(String po_date) { this.po_date = po_date; }

	@Override
	public String toString() {
		return "PointDTO [po_num=" + po_num + ", m_num=" + m_num + ", po_balance=" + po_balance + ", po_log=" + po_log
				+ ", po_date=" + po_date + "]";
	}	
}
