package com.spring.security.dto;

import com.spring.security.model.Cards;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

@Data
@AllArgsConstructor
@Schema(name = "Cards", description = "Holds user card details")
public class CardsDTO {

    @Schema(description = "Unique Identifier of the card")
    private long cardId;

    @Schema(description = "Unique Identifier of the customer")
    private long customerId;

    @Schema(description = "The credit or debit card number")
    private String cardNumber;

    @Schema(description = "Type of the card (e.g., Credit, Debit, etc.)")
    private String cardType;

    @Schema(description = "Total credit limit available on the card")
    private int totalLimit;

    @Schema(description = "Amount already used from the total limit")
    private int amountUsed;

    @Schema(description = "Remaining amount available to use from the total limit")
    private int availableAmount;

    @Schema(description = "Date when the card was created")
    private Date createDt;

    public CardsDTO(Cards card) {
        this.amountUsed = card.getAmountUsed();
        this.availableAmount = card.getAvailableAmount();
        this.cardId = card.getCardId();
        this.cardNumber = card.getCardNumber();
        this.cardType = card.getCardType();
        this.createDt = card.getCreateDt();
        this.customerId = card.getCustomerId();
        this.totalLimit = card.getTotalLimit();
    }
}
