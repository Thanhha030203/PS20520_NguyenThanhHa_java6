package com.ps20520.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps20520.bean.Order;
import com.ps20520.bean.OrderDetail;
import com.ps20520.repository.OrderDetailDAO;
import com.ps20520.repository.OrderRepository;
import com.ps20520.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

		@Autowired 
		OrderRepository orderdao;
		
		@Autowired
		OrderDetailDAO ddao;

		@Override
		public Order create(JsonNode order) {
//			// TODO Auto-generated method stub
			ObjectMapper mapper = new ObjectMapper();
			Order orders = mapper.convertValue(order, Order.class);
			orderdao.save(orders);
			TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
			};
			List<OrderDetail> details = mapper.convertValue(order.get("orderDetails"), type)
					.stream().peek(d -> d.setOrder(orders)).collect(Collectors.toList());
			
			ddao.saveAll(details);
			System.out.println("jdskfj"+ details.get(0).getOrder().getId());
		return orders;
		
		}

		@Override
		public Order findById(Long id) {
			// TODO Auto-generated method stub
			return orderdao.findById(id).get();
		}

		@Override
		public List<Order> findByUsername(String username) {
			// TODO Auto-generated method stub
			return orderdao.findByUsername(username);
		}


		
}
