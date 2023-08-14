package com.ps20520.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Data
@Entity
@Table(name = "Categories")
public class Category{
	@Id
	public String id;
	public String name;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	public List<Product> products;
}
