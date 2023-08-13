package com.poly.jpa.dao;

import com.poly.jpa.model.Account;
import com.poly.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccointDap extends JpaRepository<Account,String> {


}
