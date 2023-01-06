package com.example.headset.model.like;

public class ReviewLikeDTO {
	private int r_idx;
	private String m_id;
	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
			
	@Override
	public String toString() {
		return "ReviewLikeDTO [r_idx=" + r_idx + ", m_id=" + m_id + "]";
	}
	
	
	
}
