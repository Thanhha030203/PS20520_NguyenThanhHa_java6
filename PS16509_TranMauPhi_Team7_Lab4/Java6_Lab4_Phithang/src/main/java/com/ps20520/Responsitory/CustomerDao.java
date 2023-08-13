package com.ps20520.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.Customer;

public interface CustomerDao extends JpaRepository<Customer, String>{

}
