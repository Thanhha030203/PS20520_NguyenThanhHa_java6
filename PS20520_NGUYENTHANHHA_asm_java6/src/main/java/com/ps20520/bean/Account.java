package com.ps20520.bean;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name = "Accounts")
public class Account{
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")//, cascade = CascadeType.ALL
	List<Order> orders;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public Collection<Authority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	
}
