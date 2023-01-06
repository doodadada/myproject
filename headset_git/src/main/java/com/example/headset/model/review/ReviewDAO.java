package com.example.headset.model.review;

import java.util.List;

public interface ReviewDAO {
	List<ReviewDTO> list(int start, int end, String search_option, String keyword);
	List<ReviewDTO> list_sel_product(int start, int end, String search_option, String keyword, String p_code);
	List<Review_ProductDTO> list_product(int start, int end);
	void insert(ReviewDTO dto);
	ReviewDTO detail(int r_idx);
	void increase_r_viewcount(int r_idx);
	void update(ReviewDTO dto);
	void delete(int idx);
	int count(String search_option, String keyword);
	List<String> list_r_attach(int r_idx);
	void insert_r_attach(String r_filename);
	void update_r_attach(String r_filename, int r_idx);
	void delete_r_attach(String r_filename);
	void r_sort(int r_idx);
}
