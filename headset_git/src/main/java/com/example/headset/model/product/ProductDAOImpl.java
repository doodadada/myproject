package com.example.headset.model.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> list() {
		List<ProductDTO> items = sqlSession.selectList("product.list");
		return items;
	}
	
	@Override
	public ProductDTO sel(String p_name){
//		System.out.println("p_name:"+p_name);
		ProductDTO sel1 = sqlSession.selectOne("product.sel",p_name);
//		System.out.println("dto:"+sel1);
		return sel1;
	}

	@Override
	public ProductDTO sel_code(String p_code) {
		ProductDTO sel_code = sqlSession.selectOne("product.sel_code",p_code);
		return sel_code;
	}


}
