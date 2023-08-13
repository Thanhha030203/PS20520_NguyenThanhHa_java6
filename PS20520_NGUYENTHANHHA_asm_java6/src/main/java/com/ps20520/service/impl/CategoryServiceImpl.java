package com.ps20520.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20520.bean.Category;
import com.ps20520.repository.CategoryRepository;
import com.ps20520.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

		@Autowired
		CategoryRepository cdao;
		
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

}
