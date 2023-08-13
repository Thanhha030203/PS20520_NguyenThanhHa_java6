package com.poly.jpa.dao;

import com.poly.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> {

    @Query("SELECT o FROM Student o WHERE o.email = ?1 ")
    Student getEmail(String email);

}
