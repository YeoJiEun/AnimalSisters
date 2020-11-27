package com.example.pet.domain;

public class Pet {
	private int p_num;
	private int m_num;
	private int p_age;
	private String p_name;
	private String p_gender;
	private String p_detail;
	private String p_type;
	
	public Pet() {  }
	
	public Pet(int p_num, int m_num, int p_age, String p_name, String p_gender, String p_detail, String p_type) {
		super();
		this.p_num = p_num;
		this.m_num = m_num;
		this.p_age = p_age;
		this.p_name = p_name;
		this.p_gender = p_gender;
		this.p_detail = p_detail;
		this.p_type = p_type;
	}

	public int getP_num() { return p_num; }	
	public void setP_num(int p_num) { this.p_num = p_num; }
	
	public int getM_num() { return m_num; }	
	public void setM_num(int m_num) { this.m_num = m_num; }
	
	public int getP_age() { return p_age; }	
	public void setP_age(int p_age) { this.p_age = p_age; }
	
	public String getP_name() { return p_name; }
	public void setP_name(String p_name) { this.p_name = p_name; }
	
	public String getP_gender() { return p_gender; }	
	public void setP_gender(String p_gender) { this.p_gender = p_gender; }
	
	public String getP_detail() { return p_detail; }
	public void setP_detail(String p_detail) { this.p_detail = p_detail; }
	
	public String getP_type() { return p_type; }
	public void setP_type(String p_type) { this.p_type = p_type; }
	
	public String toString() {
		return "Pet [p_num=" + p_num + ", m_num=" + m_num + ", p_age=" + p_age + ", p_name=" + p_name + ", p_gender="
				+ p_gender + ", p_detail=" + p_detail + ", p_type=" + p_type + "]";
	}
}
