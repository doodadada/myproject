package com.example.headset.model.review;

import java.util.Date;

public class Review_ReplyDTO {
	private int rre_idx; //댓글 번호
	private int r_idx; //리뷰글 번호
	private String rre_id; //댓글 작성자 아이디
	private String rre_text; //댓글 작성 내용
	private Date rre_date; //댓글 작성 날짜
	
	
	public int getRre_idx() {
		return rre_idx;
	}
	public void setRre_idx(int rre_idx) {
		this.rre_idx = rre_idx;
	}
	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public String getRre_id() {
		return rre_id;
	}
	public void setRre_id(String rre_id) {
		this.rre_id = rre_id;
	}
	public String getRre_text() {
		return rre_text;
	}
	public void setRre_text(String rre_text) {
		this.rre_text = rre_text;
	}
	public Date getRre_date() {
		return rre_date;
	}
	public void setRre_date(Date rre_date) {
		this.rre_date = rre_date;
	}
	
	
}
