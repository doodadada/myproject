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
import com.example.headset.model.review.ReviewDTO;
import com.example.headset.model.review.Review_ProductDAO;
import com.example.headset.model.review.Review_ProductDTO;
import com.example.headset.model.review.Review_ReplyDAO;
import com.example.headset.service.PageUtil;
import com.example.headset.service.ReviewService;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	Review_ReplyDAO review_replyDao;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	Review_ProductDAO review_productDao;
	
	@RequestMapping("list_product.do")
	public ModelAndView list_product(@RequestParam(defaultValue = "1") int curPage) {
		int count_all = reviewService.count_all(); //전체 리뷰갯수<-pageutil의 기본 세팅소스값
		PageUtil page_info = new PageUtil(count_all, curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		List<Review_ProductDTO> list = reviewService.list_product(start, end);
		System.out.println("dto:"+list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/list_all");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count_all", count_all);
		map.put("page_info", page_info);
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "review/write";
	}

	@RequestMapping("insert.do")
	public String insert(ReviewDTO dto, HttpSession session) {
		String m_id = (String) session.getAttribute("m_id");
		String r_filename= (String) session.getAttribute("r_filename");
		if (r_filename==null) {
			r_filename="no_image.png";
		}
		dto.setM_id(m_id);
		System.out.println(dto.getM_id());
		dto.setR_filename(r_filename);
		reviewService.insert(dto);
		return "redirect:/review/list.do";
	}

	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "all") String search_option, @RequestParam(defaultValue = "") String keyword) {
		int count = reviewService.count(search_option, keyword);
		PageUtil page_info = new PageUtil(count, curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		List<ReviewDTO> list = reviewService.list(start, end, search_option, keyword);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/list");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("page_info", page_info);
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping("list_sel_product.do")
	public ModelAndView list_sel_product(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "all") String search_option, @RequestParam(defaultValue = "") String keyword, @RequestParam String p_code) {
		int count = reviewService.count(search_option, keyword);
		PageUtil page_info = new PageUtil(count, curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		List<ReviewDTO> list = reviewService.list_sel_product(start, end, search_option, keyword,p_code);
		ProductDTO sel = productDao.sel_code(p_code);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/list_sel_product");
		Map<String, Object> map = new HashMap<>();
		map.put("dto", sel);
		map.put("list", list);
		map.put("count", count);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("page_info", page_info);
		mav.addObject("map", map);
		return mav;
	}
	

	@RequestMapping("update.do")
	public String update(ReviewDTO dto) {
		reviewService.update(dto);
		return "redirect:/review/list.do";
	}

	@RequestMapping("detail.do")
	public ModelAndView detail(int r_idx, int cur_page, String search_option, String keyword) {
		reviewService.increase_r_viewcount(r_idx); // 조회수 증가 처리
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/view");
		mav.addObject("dto", reviewService.detail(r_idx));
		mav.addObject("count", review_replyDao.count(r_idx));
		mav.addObject("cur_page", cur_page);
		mav.addObject("search_option", search_option);
		mav.addObject("keyword", keyword);
		return mav;
	}

	@RequestMapping("delete.do")
	public String delete(int r_idx) {
		reviewService.delete(r_idx);
		reviewService.sort(r_idx);
		return "redirect:/review/list.do";
	}

	
}
