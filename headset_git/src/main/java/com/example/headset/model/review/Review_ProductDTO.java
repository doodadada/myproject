package com.example.headset.model.review;

public class Review_ProductDTO {
	private String p_code;
	private String p_name;
	private int p_price; //가격
	private int p_sound; //음질
	private int p_wear; //착용감
	private int p_design; //디자인
	private double p_point; //위에 세개 항목에 대한 평균점수
	private int cnt; //전체 리뷰갯수
	private int cnt_product; //상품별 리뷰갯수
	private String p_image;
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
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
	public double getP_point() {
		return p_point;
	}
	public void setP_point(double p_point) {
		this.p_point = p_point;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getCnt_product() {
		return cnt_product;
	}
	public void setCnt_product(int cnt_product) {
		this.cnt_product = cnt_product;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	@Override
	public String toString() {
		return "Review_ProductDTO [p_code=" + p_code + ", p_name=" + p_name + ", p_price=" + p_price + ", p_sound="
				+ p_sound + ", p_wear=" + p_wear + ", p_design=" + p_design + ", p_point=" + p_point + ", cnt=" + cnt
				+ ", cnt_product=" + cnt_product + ", p_image=" + p_image + "]";
	}
	
	
	
	
	
	
}
