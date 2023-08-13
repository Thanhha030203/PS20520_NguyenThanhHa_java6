package com.ps20520.service;

import java.util.List;

import com.ps20520.bean.Account;


public interface AccountService {

		Account findById(String username);

		List<Account> getAdministrators();

		List<Account> findAll();

	
}
