package com.example.pet.domain;
import java.io.Serializable;

@SuppressWarnings("serial")
public class UserType implements Serializable {
	private String type;
	private String value;
	
	public UserType() { }
	public UserType(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	public String getType() { return type; }
	public void setType(String type) { this.type = type; 
	}
	public String getValue() { return value; }
	public void setValue(String value) { this.value = value; }
	
	@Override
	public String toString() {
		return "UserType [type=" + type + ", value=" + value + "]";
	}
}
