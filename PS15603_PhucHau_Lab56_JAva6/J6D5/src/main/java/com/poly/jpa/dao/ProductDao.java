package com.poly.jpa.dao;

import com.poly.jpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {


}
