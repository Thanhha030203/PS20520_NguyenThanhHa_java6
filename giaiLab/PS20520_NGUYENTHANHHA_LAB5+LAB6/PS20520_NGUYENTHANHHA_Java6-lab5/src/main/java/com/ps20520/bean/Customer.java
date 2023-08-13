package com.ps20520.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Customer")
public class Customer {
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	Boolean activated;
	Boolean admin;
	@JsonIgnore
	@OneToMany(mappedBy = "customerId")
	List<Order> orders;
}
