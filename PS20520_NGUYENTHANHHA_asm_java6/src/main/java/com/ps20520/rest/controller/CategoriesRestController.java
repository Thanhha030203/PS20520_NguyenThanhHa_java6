package com.ps20520.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps20520.bean.Category;
import com.ps20520.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoriesRestController {

		@Autowired
		CategoryService categoryService;
		
		@GetMapping()
		public List<Category> getAll(){ 
			return categoryService.findAll();
		}
}
