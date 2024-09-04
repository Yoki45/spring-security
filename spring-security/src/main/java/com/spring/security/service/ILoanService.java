package com.spring.security.service;

import com.spring.security.dto.LoansDTO;

import java.util.List;

public interface ILoanService {

    List<LoansDTO> fetchLoanDetails(Long Id);
}
