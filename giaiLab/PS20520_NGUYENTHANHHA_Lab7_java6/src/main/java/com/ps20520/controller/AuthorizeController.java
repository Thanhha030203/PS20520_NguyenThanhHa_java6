package com.ps20520.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ps20520.configuration.service.SecurityResttemplate;
import com.ps20520.configuration.service.SecurityUrl;

@Controller
public class AuthorizeController {

	String url = "http://localhost:8080/rest/a";
	
	@Autowired
	SecurityResttemplate restTemple;
	
	@GetMapping("/rest/template")
	public  String demo1(Model model) { 
		model.addAttribute("db", restTemple.get(url));
		return "view";
	}
	
	@GetMapping("/rest/url")
	public  String demo2(Model model) { 
		model.addAttribute("db", SecurityUrl.get(url));
		return "view";
	}
}
