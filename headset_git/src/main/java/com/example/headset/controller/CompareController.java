package com.example.headset.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.headset.model.product.ProductDAO;
import com.example.headset.model.product.ProductDTO;
import com.example.headset.service.ProductService;

@Controller
@RequestMapping("/compare/*")
public class CompareController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductDAO productDao;

	@RequestMapping("compare.do")
	public ModelAndView list(@RequestParam(defaultValue="") String p_name1,@RequestParam(defaultValue="") String p_name2) {
		ModelAndView mav = new ModelAndView();
		List<ProductDTO> list = productService.list();
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		ProductDTO sel1 = productDao.sel(p_name1);
		map.put("dto1", sel1);
		ProductDTO sel2 = productDao.sel(p_name2);
		map.put("dto2", sel2);
		mav.setViewName("compare/compare");
		mav.addObject("map", map);
		return mav;
	}

	

}
