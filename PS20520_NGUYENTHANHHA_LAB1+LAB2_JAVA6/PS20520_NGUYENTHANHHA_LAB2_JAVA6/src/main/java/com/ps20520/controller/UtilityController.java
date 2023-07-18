package com.ps20520.controller;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps20520.bean.Student;
@Controller
public class UtilityController {
	@RequestMapping("/demo/utilities")
	public String utilities(Model model) throws Exception, DatabindException, IOException { 
		ObjectMapper obj = new ObjectMapper();
		String path = "src\\main\\resources\\static\\students.json";
	List<Student> list	= obj.readValue(new File(path), new TypeReference<List<Student>>() {});


	model.addAttribute("dssv", list);
	model.addAttribute("now", new Date());
	System.out.println("In index"+ model.getAttribute("index"));
	return "utilities";
	}
}
