package com.fpoly.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.model.StudentValidation;

@Controller
@RequestMapping("/validation")
public class ValidationController {
	
	@GetMapping("/index")
	public String doGetStudent(Model model) {
		StudentValidation student = new StudentValidation();
		model.addAttribute("student", student);
		return "validation/index";
	}
	
	@PostMapping("/result")
	public String doPostStudent(Model model, @ModelAttribute("student") @Valid StudentValidation student, BindingResult result) {
		if(result.hasErrors()) {
			return "validation/index";
		}
		return "validation/result";
	}
}
