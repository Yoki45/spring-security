package com.spring.security.service;

import com.spring.security.dto.AccountDTO;

public interface IAccountService {

    AccountDTO fetchAccountByCustomer(Long customerId);
}
