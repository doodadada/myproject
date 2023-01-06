package com.example.headset.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.headset.model.review.ReviewDAO;
import com.example.headset.model.review.ReviewDTO;
import com.example.headset.model.review.Review_ProductDAO;
import com.example.headset.model.review.Review_ProductDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDao;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	Review_ProductDAO review_productDao;

	@Override
	public List<ReviewDTO> list(int start, int end, String search_option, String keyword) {
		return reviewDao.list(start, end, search_option, keyword);
	}

	@Transactional
	@Override
	public void insert(ReviewDTO dto) {
		sqlSession.insert("review.insert", dto);
	}

	@Override
	public ReviewDTO detail(int r_idx) {
		return reviewDao.detail(r_idx);
	}

	@Override
	public void increase_r_viewcount(int r_idx) {
		reviewDao.increase_r_viewcount(r_idx);
	}

	@Transactional
	@Override
	public void update(ReviewDTO dto) {
		reviewDao.update(dto);
		}


	@Override
	public void delete(int r_idx) {
		reviewDao.delete(r_idx);
	}

	@Override
	public int count(String search_option, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		return sqlSession.selectOne("review.count", map);
	}

	@Override
	public void sort(int r_idx) {
		reviewDao.r_sort(r_idx);
	}
	
	@Override
	public int count_all() {
		return sqlSession.selectOne("review.count_all");
	}

	@Override
	public List<Review_ProductDTO> list_product(int start, int end) {
		return review_productDao.list_product(start, end);
	}

	@Override
	public List<ReviewDTO> list_sel_product(int start, int end, String search_option, String keyword, String p_code) {
		return reviewDao.list_sel_product(start, end, search_option, keyword, p_code);
	}

	

}
