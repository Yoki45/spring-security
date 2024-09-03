package com.spring.security.service;

import com.spring.security.dto.AccountDTO;
import com.spring.security.exception.NotFoundException;
import com.spring.security.model.Accounts;
import com.spring.security.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountService {

    private final AccountsRepository accountsRepository;


    @Override
    public AccountDTO fetchAccountByCustomer(Long customerId) {
        Accounts accounts = accountsRepository.findByCustomerId(customerId);

        if (accounts == null) {
            throw new NotFoundException("Account not found");
        }
        return new AccountDTO(accounts);
    }
}
