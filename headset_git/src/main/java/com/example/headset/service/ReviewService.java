package com.example.headset.service;

import java.util.List;

import com.example.headset.model.review.ReviewDTO;
import com.example.headset.model.review.Review_ProductDTO;

public interface ReviewService {
	List<ReviewDTO> list(int start, int end,
			String search_option, String keyword);
	List<ReviewDTO> list_sel_product(int start, int end,
			String search_option, String keyword, String p_code);
	List<Review_ProductDTO> list_product(int start, int end);
	void insert(ReviewDTO dto);
	ReviewDTO detail(int r_idx);
	void increase_r_viewcount(int r_idx);
	void update(ReviewDTO dto);
	void delete(int r_idx);
	int count(String search_option, String keyword);
	int count_all();
	void sort(int r_idx);
}
