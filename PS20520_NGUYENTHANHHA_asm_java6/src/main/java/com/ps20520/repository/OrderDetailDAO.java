package com.ps20520.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

}
