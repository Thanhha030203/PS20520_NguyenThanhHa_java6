package com.ps20520.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ps20520.bean.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	void delete(Integer id);

}
