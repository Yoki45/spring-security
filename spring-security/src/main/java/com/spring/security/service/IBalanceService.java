package com.spring.security.service;

import com.spring.security.dto.BalanceDTO;

import java.util.List;

public interface IBalanceService  {

     List<BalanceDTO> fetchBalance(Long Id);
}
