package com.poly.jpa.dao;

import com.poly.jpa.model.Category;
import com.poly.jpa.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {


}
