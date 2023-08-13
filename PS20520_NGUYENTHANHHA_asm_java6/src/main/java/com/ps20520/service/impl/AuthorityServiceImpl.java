package com.ps20520.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20520.bean.Account;
import com.ps20520.bean.Authority;
import com.ps20520.repository.AuthorityRepository;
import com.ps20520.service.AccountService;
import com.ps20520.service.AuthorityService;


@Service
public class AuthorityServiceImpl implements AuthorityService {

		@Autowired
		AccountService acdao;
		
		@Autowired 
		AuthorityRepository dao;
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		// TODO Auto-generated method stub
		List<Account> accounts = acdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}
	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return dao.save(auth);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 dao.deleteById(id);
	}

}
