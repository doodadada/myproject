package com.example.headset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.headset.model.product.ProductDAO;
import com.example.headset.model.product.ProductDTO;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDao;
		
	
	@Override
	public List<ProductDTO> list() {
		return productDao.list();
	}

}
