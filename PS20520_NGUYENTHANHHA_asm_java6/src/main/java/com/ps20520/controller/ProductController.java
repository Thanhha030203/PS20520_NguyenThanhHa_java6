package com.ps20520.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps20520.bean.Product;
import com.ps20520.service.ProductService;

@Controller
public class ProductController {

		@Autowired
		ProductService productService;
	
		@RequestMapping("/product/list")
		public String list(Model model,@RequestParam("cid") Optional<String> cid) {
			if(cid.isPresent()) { 
				// nếu để cid không thì nó sẽ buộc trả về loại category buộc phải có Optional
				// Nếu để cid.get() thì nó sẽ trả về id thôi không cần có Optional
				List<Product> list = productService.findByCategoryId(cid.get());
				model.addAttribute("items", list);
			}
			else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
			}
			return "product/list";
		}
		@RequestMapping("/product/detail/{id}")
		public String detail(Model model, @PathVariable("id") Integer id) {
			Product item = productService.findById(id);
			model.addAttribute("item", item);
			return "product/detail";
		}
}
