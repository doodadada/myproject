package com.example.headset.model.review;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReviewDTO {
	private int r_idx;
	private String p_code;
	private String r_title;
	private int b_idx;
	private String m_id;
	private String r_text;
	private String r_filename;
	private Date r_date;
	private int r_viewcount;
	private String r_state;
	private int cnt;
	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getR_text() {
		return r_text;
	}
	public void setR_text(String r_text) {
		this.r_text = r_text;
	}
	public String getR_filename() {
		return r_filename;
	}
	public void setR_filename(String r_filename) {
		this.r_filename = r_filename;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	public int getR_viewcount() {
		return r_viewcount;
	}
	public void setR_viewcount(int r_viewcount) {
		this.r_viewcount = r_viewcount;
	}
	public String getR_state() {
		return r_state;
	}
	public void setR_state(String r_state) {
		this.r_state = r_state;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "ReviewDTO [r_idx=" + r_idx + ", p_code=" + p_code + ", r_title=" + r_title + ", b_idx=" + b_idx
				+ ", m_id=" + m_id + ", r_text=" + r_text + ", r_filename=" + r_filename + ", r_date=" + r_date
				+ ", r_viewcount=" + r_viewcount + ", r_state=" + r_state + ", cnt=" + cnt + "]";
	}

	
	
	
	
}
