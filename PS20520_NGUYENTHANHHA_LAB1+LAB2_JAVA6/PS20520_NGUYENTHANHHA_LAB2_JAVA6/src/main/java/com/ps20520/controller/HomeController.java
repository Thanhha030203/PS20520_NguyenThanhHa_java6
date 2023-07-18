package com.ps20520.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps20520.bean.Student;

@Controller
public class HomeController {

		@RequestMapping("/home/index")
		public String index(Model model) throws Exception, DatabindException, IOException { 
			model.addAttribute("message", "Welcome to Thymeleaf");
			ObjectMapper obj = new ObjectMapper();
			String path ="src\\main\\resources\\static\\student.json";
			Student st = obj.readValue(new File(path), Student.class);
			model.addAttribute("sv", st);
			return "home/index";
		}

		
}
