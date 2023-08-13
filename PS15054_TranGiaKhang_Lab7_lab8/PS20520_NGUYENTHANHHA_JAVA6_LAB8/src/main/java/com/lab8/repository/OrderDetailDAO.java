package com.lab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab8.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer>{

}
