package com.ps20520.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps20520.bean.Product;
import com.ps20520.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) { 
		return productService.findById(id);
	}
	@GetMapping("")
	public List<Product> getAll() { 
		return productService.findAll();
	}	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) { 
		 productService.delete(id);
	}	
}
