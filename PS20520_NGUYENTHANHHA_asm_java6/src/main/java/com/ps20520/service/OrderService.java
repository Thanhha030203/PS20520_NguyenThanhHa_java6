package com.ps20520.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.ps20520.bean.Order;

public interface OrderService {

		Order create(JsonNode order);

		Order findById(Long id);

		List<Order> findByUsername(String username);

	

		
}
