package com.ps20520.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
