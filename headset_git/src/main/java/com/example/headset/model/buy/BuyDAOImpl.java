package com.example.headset.model.buy;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuyDAOImpl implements BuyDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BuyDTO> list() {
		return sqlSession.selectList("buy.list");
	}

}
