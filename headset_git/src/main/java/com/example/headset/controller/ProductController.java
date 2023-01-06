package com.example.headset.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.headset.model.product.ProductDAO;
import com.example.headset.model.product.ProductDTO;
import com.example.headset.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductDAO productDao;
	
	@RequestMapping("list.do")
	public ModelAndView list() {
		List<ProductDTO> list = productService.list();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product/list");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		mav.addObject("map", map);
		return mav;
	}
	
}
