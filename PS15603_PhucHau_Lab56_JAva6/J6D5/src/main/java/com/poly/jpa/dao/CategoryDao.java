package com.poly.jpa.dao;

import com.poly.jpa.model.Account;
import com.poly.jpa.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {


}
