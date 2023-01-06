package com.example.headset.model.member;

public class MemberDTO {
	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_phone;
	private String m_email;
	private String m_address;
	private int m_point;
	private String m_gender;
	private int m_age;
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	public int getM_point() {
		return m_point;
	}
	public void setM_point(int m_point) {
		this.m_point = m_point;
	}
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public int getM_age() {
		return m_age;
	}
	public void setM_age(int m_age) {
		this.m_age = m_age;
	}
	@Override
	public String toString() {
		return "MemberDTO [m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name=" + m_name + ", m_phone=" + m_phone
				+ ", m_email=" + m_email + ", m_address=" + m_address + ", m_point=" + m_point + ", m_gender="
				+ m_gender + ", m_age=" + m_age + "]";
	}
	
	
}
