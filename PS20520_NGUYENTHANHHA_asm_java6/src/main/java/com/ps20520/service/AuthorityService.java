package com.ps20520.service;

import java.util.List;

import com.ps20520.bean.Authority;




public interface AuthorityService {

	List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority auth);

	void delete(Integer id);

}
