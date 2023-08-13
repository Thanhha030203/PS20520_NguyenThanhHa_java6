package com.ps20520.bean;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Orders")
public class Order {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id;
		String address;
		int status;
		@JsonIgnore
		@OneToMany(mappedBy = "orderId")
		List<OrderDetail> details;
		
		@ManyToOne
		@JoinColumn(name = "customerid")
		Customer customerId;
		
}
