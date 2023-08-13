package com.ps20520.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.Order;


public interface OrderDao extends JpaRepository<Order, Long> {

}
