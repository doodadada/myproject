package com.example.headset.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.headset.model.member.AdminDAO;
import com.example.headset.model.member.AdminDTO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	AdminDAO adminDao;

	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}

	@RequestMapping("login_check.do")
	public ModelAndView login_check(AdminDTO dto, HttpSession session, ModelAndView mav) {
		String a_name = adminDao.login(dto);
		dto.toString();
		if (a_name != null) { // 로그인 성공
			// 세션 변수 저장
			session.setAttribute("a_id", dto.getA_id());
			session.setAttribute("a_name", a_name);
			session.setAttribute("m_id", dto.getA_id());
			session.setAttribute("m_name", a_name);
			mav.setViewName("admin/admin"); // 페이지 이름
			mav.addObject("message", "success"); // 자료 저장
		} else { // 로그인 실패
			mav.setViewName("admin/login");
			mav.addObject("message", "error");
		}
		return mav;
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 클리어
		return "redirect:/admin/login.do?message=logout";
	}
}
