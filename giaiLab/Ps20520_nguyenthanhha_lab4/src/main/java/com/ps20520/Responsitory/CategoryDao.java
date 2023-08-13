package com.ps20520.Responsitory;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.Category;

public interface CategoryDao extends JpaRepository<Category, String> {

}
