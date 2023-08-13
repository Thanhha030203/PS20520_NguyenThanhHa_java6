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
@Entity(name = "Categories")
public class Category {
	@Id
	String id;
	String name;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> products;

}
