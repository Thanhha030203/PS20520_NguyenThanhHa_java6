package com.ps20520.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20520.bean.Role;
import com.ps20520.repository.RoleRepository;
import com.ps20520.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{

		@Autowired
		RoleRepository rdao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rdao.findAll();
	}

}
