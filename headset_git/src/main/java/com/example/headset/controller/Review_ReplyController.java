package com.example.headset.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.headset.model.review.Review_ReplyDAO;
import com.example.headset.model.review.Review_ReplyDTO;
import com.example.headset.service.PageUtil;

@RestController
@RequestMapping("/review_reply/*")
public class Review_ReplyController {

	@Autowired
	Review_ReplyDAO review_replyDao;

	@RequestMapping("insert.do")
	public void insert(Review_ReplyDTO dto, HttpSession session) {
		String rre_id = (String) session.getAttribute("m_id");
		dto.setRre_id(rre_id);
		System.out.println("rre_id:"+dto.getRre_id());
		review_replyDao.insert(dto); // 댓글 저장
	}

	
	
	@RequestMapping("/delete/{rre_idx}")
	public ResponseEntity<String> delete(@PathVariable("rre_idx") int rre_idx) {
		ResponseEntity<String> entity = null;
		try {
			review_replyDao.delete(rre_idx); // 레코드 삭제
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping("/detail/{rre_idx}")
	public ModelAndView detail(@PathVariable("rre_idx") int rre_idx, ModelAndView mav) {
		Review_ReplyDTO dto = review_replyDao.detail(rre_idx); // 댓글 상세 내용
		mav.setViewName("review/review_reply_detail");
		mav.addObject("dto", dto);
		return mav;
	}

	@RequestMapping("list.do")
	public ModelAndView list(int r_idx, @RequestParam(defaultValue = "1") int curPage, ModelAndView mav) {
	int count = review_replyDao.count(r_idx);
	PageUtil page_info = new PageUtil(count, curPage);
	int start = page_info.getPageBegin();
	int end = page_info.getPageEnd();
	List<Review_ReplyDTO> list = review_replyDao.list(r_idx, start,	end);
	mav.setViewName("review/review_reply");
	mav.addObject("list", list);
	mav.addObject("page_info", page_info);
	return mav;
	}
	
	@RequestMapping("list_json.do")
	public @ResponseBody List<Review_ReplyDTO> list_json(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam int rre_idx) {
		int count = review_replyDao.count(rre_idx); // 댓글 갯수
		PageUtil page_info = new PageUtil(count, curPage);
		int start = page_info.getPageBegin();
		int end = page_info.getPageEnd();
		List<Review_ReplyDTO> list = review_replyDao.list(rre_idx, start, end);
		return list;
	}
	
	@RequestMapping("/update/{rre_idx}")
	public ResponseEntity<String> update(@PathVariable("rre_idx")
	int rre_idx, @RequestBody Review_ReplyDTO dto) {
	ResponseEntity<String> entity = null;
	try {
	dto.setRre_idx(rre_idx);
	review_replyDao.update(dto); // 레코드 수정
	entity = new ResponseEntity<String>("success", HttpStatus.OK);
	} catch (Exception e) {
	e.printStackTrace();
	entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	return entity;
	}


}
