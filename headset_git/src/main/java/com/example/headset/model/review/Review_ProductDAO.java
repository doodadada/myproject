package com.example.headset.model.review;

import java.util.List;

public interface Review_ProductDAO {
	List<Review_ProductDTO> list_product(int start, int end);
	int count_product(String search_option, String keyword);
}
