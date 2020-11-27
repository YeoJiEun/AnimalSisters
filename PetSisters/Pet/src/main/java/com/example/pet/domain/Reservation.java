package com.example.pet.domain;

public class Reservation {	
	private String m_phone;
	private int b_num;
	private int m_num;
	private String r_completeTF;
	private String r_confirmTF;
	private String r_date ;
	private int sitter_num;
	private String b_title;
	private String m_name;
	
	public Reservation() {  }

	// 시터 -> 예약보기
	public Reservation(String b_title, String r_completeTF, String r_confirmTF, String r_date, String m_name, int sitter_num) {
		super();
		this.b_title = b_title;
		this.m_name = m_name;
		this.r_completeTF = r_completeTF;
		this.r_confirmTF = r_confirmTF;
		this.r_date = r_date;
		this.sitter_num = sitter_num;
	}

	// 일반 -> 예약보기
	public Reservation(int b_num, String r_completeTF, String r_confirmTF, String r_date, int m_num, int sitter_num) {
		super();
		this.b_num = b_num;
		this.m_num = m_num;
		this.r_completeTF = r_completeTF;
		this.r_confirmTF = r_confirmTF;
		this.r_date = r_date;
		this.sitter_num = sitter_num;
	}

	public Reservation(String m_phone, int b_num, int m_num, String r_completeTF, String r_confirmTF, String r_date, int sitter_num, String b_title, String m_name) {
		super();
		this.m_phone = m_phone;
		this.b_num = b_num;
		this.m_num = m_num;
		this.r_completeTF = r_completeTF;
		this.r_confirmTF = r_confirmTF;
		this.r_date = r_date;
		this.sitter_num = sitter_num;
		this.b_title = b_title;
		this.m_name = m_name;
	}
	
	public String getB_title() { return b_title; }
	public void setB_title(String b_title) { this.b_title = b_title; }

	public String getM_name() { return m_name; }
	public void setM_name(String m_name) { this.m_name = m_name; }	
	
	public int getSitter_num() { return sitter_num; }
	public void setSitter_num(int sitter_num) { this.sitter_num = sitter_num; }

	public int getB_num() { return b_num; }
	public void setB_num(int b_num) { this.b_num = b_num; }
	
	public int getM_num() { return m_num; }
	public void setM_num(int m_num) { this.m_num = m_num; }
	
	public String getR_completeTF() { return r_completeTF; }
	public String getM_phone() { return m_phone; }

	public void setM_phone(String m_phone) { this.m_phone = m_phone; }
	public void setR_completeTF(String r_completeTF) { this.r_completeTF = r_completeTF; }
	
	public String getR_confirmTF() { return r_confirmTF; }
	public void setR_confirmTF(String r_confirmTF) { this.r_confirmTF = r_confirmTF; }
	
	public String getR_date() { return r_date; }
	public void setR_date(String r_date) { this.r_date = r_date; }
	
	@Override
	public String toString() {
		return "ReservationDTO [b_num=" + b_num + ", m_num=" + m_num + ", completeTF=" + r_completeTF + ", confirmTF="
				+ r_confirmTF + ", r_date=" + r_date + "]";
	}
}
