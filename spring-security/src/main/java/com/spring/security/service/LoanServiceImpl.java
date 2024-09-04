package com.spring.security.service;

import com.spring.security.dto.LoansDTO;
import com.spring.security.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements ILoanService {

    private final LoanRepository loanRepository;


    @Override
    public List<LoansDTO> fetchLoanDetails(Long Id) {
        return  loanRepository.findByCustomerIdOrderByStartDtDesc(Id)
                .stream().map(LoansDTO::new).collect(Collectors.toList());
    }
}
