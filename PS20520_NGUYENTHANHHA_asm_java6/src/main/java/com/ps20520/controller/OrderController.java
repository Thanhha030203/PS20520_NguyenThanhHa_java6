package com.ps20520.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps20520.service.OrderService;


@Controller
public class OrderController {

		@Autowired
		OrderService orderservice;
		@RequestMapping("/order/checkout")
		public String checkout() { 
			return "order/checkout";
		}
		@RequestMapping("/order/list")
		public String list(Model model, HttpServletRequest request) { 
			String username = request.getRemoteUser();
			model.addAttribute("orders", orderservice.findByUsername(username));
			
			return "order/list";
		}
		@RequestMapping("/order/detail/{id}")
		public String detail(@PathVariable("id") Long id,Model model) { 
			model.addAttribute("order", orderservice.findById(id));
			return "order/detail";
		}
}
