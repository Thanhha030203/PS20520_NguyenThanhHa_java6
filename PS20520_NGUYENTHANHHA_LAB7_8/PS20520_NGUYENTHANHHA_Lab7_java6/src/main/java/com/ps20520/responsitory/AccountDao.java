package com.ps20520.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20520.bean.Account;

public interface AccountDao extends JpaRepository<Account, String> {

}
