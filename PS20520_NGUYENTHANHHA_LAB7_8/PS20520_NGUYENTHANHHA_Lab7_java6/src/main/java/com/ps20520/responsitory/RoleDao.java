package com.ps20520.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
