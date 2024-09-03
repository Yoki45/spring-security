package com.spring.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Schema(name = "Balance", description = "Holds user balance details")
public class AccountTransactionDTO {

    @Schema(description = "Unique Identifier of the transaction")
    private String transactionId;

    @Schema(description = "Account number associated with the transaction")
    private long accountNumber;

    @Schema(description = "Unique Identifier of the customer associated with the transaction")
    private long customerId;

    @Schema(description = "Date and time when the transaction occurred")
    private Date transactionDt;

    @Schema(description = "Summary or brief description of the transaction")
    private String transactionSummary;

    @Schema(description = "Type of the transaction (e.g., Credit, Debit)")
    private String transactionType;

    @Schema(description = "Amount involved in the transaction")
    private int transactionAmt;

    @Schema(description = "Account balance after the transaction was completed")
    private int closingBalance;

    @Schema(description = "Date when the transaction record was created")
    private Date createDt;

}
