package com.example.headset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.headset.service.BuyService;



@Controller
@RequestMapping("/buy/*")
public class BuyController {

	@Autowired
	BuyService buyService;
	
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.addObject("items", buyService.list());
		mav.setViewName("list");
		return mav;
	}
}
