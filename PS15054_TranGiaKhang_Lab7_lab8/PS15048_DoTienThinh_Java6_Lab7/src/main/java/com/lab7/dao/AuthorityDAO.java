package com.lab7.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab7.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{

}
