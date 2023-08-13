package com.ps20520.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long>{

}
