package com.lab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab7.service.UserService;

@Controller
public class AuthController {
	@RequestMapping("/auth/login/form")
	public String getFormLogin() {
		return "auth/login";
	}
	
	@RequestMapping("/auth/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/login/denied")
	public String getDenied(Model model) {
		model.addAttribute("message", "Lỗi quyền truy cập!");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logout/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "forward:/auth/login/form";
	}
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oAuth2Token) {
		userService.loginOAuth2(oAuth2Token);
		return "forward:/auth/login/form";
	}
}
