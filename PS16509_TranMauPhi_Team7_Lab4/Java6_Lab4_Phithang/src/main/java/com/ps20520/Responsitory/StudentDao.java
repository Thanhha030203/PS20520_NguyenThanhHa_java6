package com.ps20520.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.Student;

public interface StudentDao extends JpaRepository<Student, String> {

}
