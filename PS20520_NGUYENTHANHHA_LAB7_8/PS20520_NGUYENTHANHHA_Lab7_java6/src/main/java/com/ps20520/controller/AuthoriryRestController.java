package com.ps20520.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps20520.bean.Account;
import com.ps20520.bean.Authority;
import com.ps20520.bean.Role;
import com.ps20520.responsitory.AccountDao;
import com.ps20520.responsitory.AuthorityDao;
import com.ps20520.responsitory.RoleDao;



@CrossOrigin("*")
@RestController
public class AuthoriryRestController {
		@Autowired AuthorityDao authorityDao;
		@Autowired RoleDao roleDao;
		@Autowired AccountDao accountDao ;
		
		@GetMapping("/rest/a")
		public Map<String, Object> getAuthorities(Model model){ 
			Map<String, Object> data = new HashMap<>();
			data.put("authorities", authorityDao.findAll());
			data.put("roles", roleDao.findAll());
			data.put("accounts", accountDao.findAll());
			return data;
		}
		
		@PostMapping("/rest/a")
		public Authority create (@RequestBody Authority authority) { 
			return authorityDao.save(authority);
		}
		
		@DeleteMapping("/rest/a/{id}")
		public void delete(@PathVariable("id") Long id){ 	
			authorityDao.deleteById(id);
		}
}
