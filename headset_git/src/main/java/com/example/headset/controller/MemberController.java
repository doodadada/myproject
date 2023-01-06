package com.example.headset.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.headset.model.member.MemberDAO;
import com.example.headset.model.member.MemberDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	MemberDAO memberDao;
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}

	@RequestMapping("login_check.do")
	public ModelAndView login_check(MemberDTO dto, HttpSession session, ModelAndView mav) {
		String m_name = memberDao.login(dto);
		dto.toString();
		if (m_name != null) { // 로그인 성공
			// 세션 변수 저장
			session.setAttribute("m_id", dto.getM_id());
			session.setAttribute("m_name", m_name);
			session.setAttribute("m_id", dto.getM_id());
			session.setAttribute("m_name", m_name);
			mav.setViewName("member/member"); // 페이지 이름
			mav.addObject("message", "success"); // 자료 저장
		} else { // 로그인 실패
			mav.setViewName("member/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 클리어
		return "redirect:/member/login.do?message=logout";
	}
}
