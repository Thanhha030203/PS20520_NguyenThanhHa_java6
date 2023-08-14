package com.ps20520.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Double price;
	Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "Productid")
	public Product product;
	
	@ManyToOne
	@JoinColumn(name = "Orderid")
	Order order;

	public Order setOrder(Order orders) {
		// TODO Auto-generated method stub
		this.order = orders;
		return this.order;
	}



	



}
