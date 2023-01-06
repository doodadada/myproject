package com.example.headset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "Head Rosettes");
		return "home";
	}

	@RequestMapping("login.do")
	public String login() {
		return "login/login";
	}

	@RequestMapping("login_result.do")
	public String login_result(String id, String pw, Model model) {
		String result = "";
		if (id.equals("kim") && pw.equals("1234")) {
			result = "환영합니다";
		} else {
			result = "아이디 또는 비밀번호가 틀렸습니다.";
		}
		model.addAttribute("result", result);
		return "login/login_result";
	}

}
