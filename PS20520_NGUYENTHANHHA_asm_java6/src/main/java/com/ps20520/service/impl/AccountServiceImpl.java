package com.ps20520.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20520.bean.Account;
import com.ps20520.repository.AccountRepository;
import com.ps20520.service.AccountService;

@Service
public class AccountServiceImpl  implements AccountService{

		@Autowired
		AccountRepository adao;
		
	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return adao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return  adao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return adao.findAll();
	}

}
