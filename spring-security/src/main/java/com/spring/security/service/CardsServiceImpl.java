package com.spring.security.service;

import com.spring.security.dto.CardsDTO;
import com.spring.security.exception.InvalidInputException;
import com.spring.security.model.Cards;
import com.spring.security.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CardsServiceImpl  implements ICardsService{

    private final CardsRepository cardsRepository;



    @Override
    public List<CardsDTO> fetchCardDetails(Long id) {

        if (id == null) {
            throw new InvalidInputException("Missing required field");
        }

        List<Cards> cards = cardsRepository.findByCustomerId(id);

        return cards.stream()
                .map(CardsDTO::new)
                .collect(Collectors.toList());

    }
}
