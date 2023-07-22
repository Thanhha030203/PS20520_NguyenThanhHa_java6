package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@GetMapping("/index")
	public String doGetStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student/index";
	}
	
	@PostMapping("/result")
	public String doPostStudent(@ModelAttribute("student") Student student) {
		return "student/result";
	}
}
