package com.example.headset.model.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Review_ProductDAOImpl implements Review_ProductDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Review_ProductDTO> list_product(int start, int end) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start-1);
		map.put("end", end);
		System.out.println("dto from daoimpl"+map.get("start"));
		return sqlSession.selectList("review.list_product", map);
		
	}

	@Override
	public int count_product(String search_option, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		return sqlSession.selectOne("review.count_product", map);
	}

}
