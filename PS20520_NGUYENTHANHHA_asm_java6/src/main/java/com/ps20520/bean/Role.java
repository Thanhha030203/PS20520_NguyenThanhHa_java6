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
@Table(name = "Roles")
public class Role {
	@Id
	String id;
	String name;
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
