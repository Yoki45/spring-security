package com.spring.security.controller;

import com.spring.security.dto.CardsDTO;
import com.spring.security.dto.ErrorResponseDTO;
import com.spring.security.dto.ResponseDTO;
import com.spring.security.repository.CardsRepository;
import com.spring.security.service.ICardsService;
import com.spring.security.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "APIs to test Spring security concepts",
        description = " ")
@RequiredArgsConstructor
public class CardsController {

    private final ICardsService cardsService;


    @Operation(summary = "Fetch Card Details  REST API", description = "Fetch Card details")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @GetMapping()
    public ResponseEntity<List<CardsDTO>> getCardsDetails (@RequestParam Long customerId) {
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(cardsService.fetchCardDetails(customerId));

    }
}
