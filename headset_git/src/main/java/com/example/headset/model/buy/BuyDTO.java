package com.example.headset.model.buy;

import java.util.Date;

public class BuyDTO {
	private int b_idx;
	private String p_code;
	private int amount;
	private String m_id;
	private String m_name;
	private String m_phone;
	private String m_email;
	private String m_address;
	private String memo;
	private int b_money;
	private String card_company;
	private String card_num;
	private Date b_date;
	private String review_yn;
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getB_money() {
		return b_money;
	}
	public void setB_money(int b_money) {
		this.b_money = b_money;
	}
	public String getCard_company() {
		return card_company;
	}
	public void setCard_company(String card_company) {
		this.card_company = card_company;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public String getReview_yn() {
		return review_yn;
	}
	public void setReview_yn(String review_yn) {
		this.review_yn = review_yn;
	}
	
	@Override
	public String toString() {
		return "BuyDTO [b_idx=" + b_idx + ", p_code=" + p_code + ", amount=" + amount + ", m_id=" + m_id + ", m_name="
				+ m_name + ", m_phone=" + m_phone + ", m_email=" + m_email + ", m_address=" + m_address + ", memo="
				+ memo + ", b_money=" + b_money + ", card_company=" + card_company + ", card_num=" + card_num
				+ ", b_date=" + b_date + ", review_yn=" + review_yn + "]";
	}
	
	
	
}
