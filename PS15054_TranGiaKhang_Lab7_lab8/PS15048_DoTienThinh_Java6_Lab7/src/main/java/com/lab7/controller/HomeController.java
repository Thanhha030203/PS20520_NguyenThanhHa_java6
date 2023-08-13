package com.lab7.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest req;
	@RequestMapping("/home/index")
	public String index(Model model) {
		model.addAttribute("message", "This is a home page!");
		return "home/index";
	}
	@RequestMapping("/home/about")
	public String about(Model model) {
		model.addAttribute("message", "This is a about page!");
		return "home/index";
	}
//	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/home/admin")
	public String getAdmin(Model model) {
		if(!req.isUserInRole("ADMIN")) {
			return "redirect:/auth/login/denied";
		}
		model.addAttribute("message", "Đây là trang admin!");
		return "home/index";
	}
//	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@RequestMapping("/home/user")
	public String getUser(Model model) {
		if(!req.isUserInRole("ADMIN") && !req.isUserInRole("USER")) {
			return "redirect:/auth/login/denied";
		}
		model.addAttribute("message", "Đây là trang User!");
		return "home/index";
	}
	
	@RequestMapping("/auth/authorizing")
	public String getAuthorizing() {
		return "authorize/index.html";
	}
	
	//@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home/authenticated")
	public String getAuthenticated(Model model) {
		if(req.getRemoteUser() == null) {
			return "redirect:/auth/login/form";
		}
		model.addAttribute("message", "Đây là trang Authenticated!");
		return "home/index";
	}
}
