package com.example.headset.model.product;

public class Product_SatisfactionDTO {
	private String p_code;
	private String m_id;
	private int p_sound;
	private int p_wear;
	private int p_design;
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getP_sound() {
		return p_sound;
	}
	public void setP_sound(int p_sound) {
		this.p_sound = p_sound;
	}
	public int getP_wear() {
		return p_wear;
	}
	public void setP_wear(int p_wear) {
		this.p_wear = p_wear;
	}
	public int getP_design() {
		return p_design;
	}
	public void setP_design(int p_design) {
		this.p_design = p_design;
	}
	@Override
	public String toString() {
		return "Product_SatisfactionDTO [p_code=" + p_code + ", m_id=" + m_id + ", p_sound=" + p_sound + ", p_wear="
				+ p_wear + ", p_design=" + p_design + "]";
	}
	
	
}
