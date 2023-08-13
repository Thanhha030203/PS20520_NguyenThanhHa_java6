package com.poly.jpa.dao;

import com.poly.jpa.model.Category;
import com.poly.jpa.model.Orderdetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<Orderdetail,Integer> {


}
