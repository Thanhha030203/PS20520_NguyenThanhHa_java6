package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/index")
	public String doGetHome(Model model) {
		model.addAttribute("message", "Chào mừng bạn đã vào trang chủ");
		return "home/index";
	}
	
	@GetMapping("/about")
	public String doGetAbout(Model model) {
		model.addAttribute("message", "Chào mừng bạn đã vào trang giới thiệu");
		return "home/about";
	}
	
	@GetMapping("/contact")
	public String doGetContact(Model model) {
		model.addAttribute("message", "Chào mừng bạn đã vào trang liên hệ");
		return "home/contact";
	}
	
	@GetMapping("/feedback")
	public String doGetFeedback(Model model) {
		model.addAttribute("message", "Chào mừng bạn đã vào trang góp ý");
		return "home/feedback";
	}
	
	@GetMapping("/login")
	public String doGetLogin(Model model) {
		model.addAttribute("message", "Chào mừng bạn đã vào trang đăng nhập");
		return "home/login";
	}
	
	@GetMapping("/register")
	public String doGetRegister(Model model) {
		model.addAttribute("message", "Chào mừng bạn đã vào trang đăng ký");
		return "home/register";
	}
	
}
