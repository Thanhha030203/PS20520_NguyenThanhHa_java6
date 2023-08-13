package com.lab7.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lab7.dao.AccountDAO;
import com.lab7.dao.AuthorityDAO;
import com.lab7.dao.RoleDAO;
import com.lab7.entity.Authority;

@CrossOrigin("*")
@RestController
public class AuthorityRestController {
	@Autowired
	AuthorityDAO authorityDAO;
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	AccountDAO accountDAO;
	
	@GetMapping("/rest/authorities")
	public Map<String, Object> getAuthorities() {
		Map<String, Object> data = new HashMap<>();
		data.put("accounts", accountDAO.findAll());
		data.put("roles", roleDAO.findAll());
		data.put("authorities", authorityDAO.findAll());
		return data;
	}
	
	@DeleteMapping("/rest/authorities/{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityDAO.deleteById(id);
	}
	
	@PostMapping("/rest/authorities")
	public Authority create(@RequestBody Authority authority) {
		return authorityDAO.save(authority);
	}
}
