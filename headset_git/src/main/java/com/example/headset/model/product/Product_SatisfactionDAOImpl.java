package com.example.headset.model.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Product_SatisfactionDAOImpl implements Product_SatisfactionDAO {

	@Autowired
	SqlSession sqlSession;	
	
	@Override
	public List<Product_SatisfactionDTO> list() {
		List<Product_SatisfactionDTO> items = sqlSession.selectList("product.list");
		return items;
	}

}
