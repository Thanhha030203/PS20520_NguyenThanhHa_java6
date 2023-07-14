package com.ps20520.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.ps20520.bean.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StudentController{
	@RequestMapping("/student")
	public String student(Model model, @RequestParam("index") Optional<Integer> index) throws Exception, DatabindException, IOException { 
		ObjectMapper obj = new ObjectMapper();
		String path = "src\\main\\resources\\static\\students.json";
	List<Student> list	= obj.readValue(new File(path), new TypeReference<List<Student>>() {});

	Student st = list.get(index.orElse(0));
	model.addAttribute("sv", st);
	model.addAttribute("index", index.orElse(0));
	System.out.println("In index"+ model.getAttribute("index"));
	return "student";
	}
}
