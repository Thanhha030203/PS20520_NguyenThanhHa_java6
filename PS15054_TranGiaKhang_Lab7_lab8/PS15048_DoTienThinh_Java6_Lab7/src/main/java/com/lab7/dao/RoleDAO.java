package com.lab7.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab7.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

}
