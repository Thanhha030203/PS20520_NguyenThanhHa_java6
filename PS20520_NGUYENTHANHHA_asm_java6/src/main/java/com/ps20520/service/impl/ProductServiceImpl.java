package com.ps20520.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps20520.bean.Product;
import com.ps20520.repository.ProductRepository;
import com.ps20520.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

		@Autowired
		ProductRepository pdao;

		@Override
		public List<Product> findAll() {
			// TODO Auto-generated method stub
			return pdao.findAll();
		}

		@Override
		public Product findById(Integer id) {
			// TODO Auto-generated method stub
			return pdao.findById(id).get();
		}

		@Override
		public List<Product> findByCategoryId(String cid) {
			// TODO Auto-generated method stub
			return pdao.findByCategoryId(cid);
		}

		@Override
		public void delete(Integer id) {
			pdao.deleteById(id);
			
		}
}
