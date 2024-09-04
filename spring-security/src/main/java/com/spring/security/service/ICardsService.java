package com.spring.security.service;

import com.spring.security.dto.CardsDTO;

import java.util.List;

public interface ICardsService {


    List<CardsDTO> fetchCardDetails(Long id);
}
