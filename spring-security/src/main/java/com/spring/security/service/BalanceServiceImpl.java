package com.spring.security.service;

import com.spring.security.dto.BalanceDTO;
import com.spring.security.repository.AccountTransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements IBalanceService{

    private final AccountTransactionsRepository accountTransactionsRepository;


    @Override
    public List<BalanceDTO> fetchBalance(Long Id) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(Id)
                .stream()
                .map(BalanceDTO::new)
                .collect(Collectors.toList());


    }
}
