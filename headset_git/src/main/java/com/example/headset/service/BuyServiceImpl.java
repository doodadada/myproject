package com.example.headset.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.headset.model.buy.BuyDAO;
import com.example.headset.model.buy.BuyDTO;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	BuyDAO buyDao;
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BuyDTO> list() {
		return buyDao.list();
	}

}
