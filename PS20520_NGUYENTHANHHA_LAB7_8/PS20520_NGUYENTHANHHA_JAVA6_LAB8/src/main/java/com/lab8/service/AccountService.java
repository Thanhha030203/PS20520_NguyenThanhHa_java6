package com.lab8.service;

import java.util.List;

import com.lab8.entity.Account;

public interface AccountService {
	
	public Account findById(String username);

	public List<Account> getAdministrators();

	public List<Account> findAll();
}
