package com.spring.security.dto;

import com.spring.security.model.AccountTransactions;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Schema(name = "Balance", description = "Holds bank user balance details")
public class BalanceDTO {

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


    public BalanceDTO(AccountTransactions transaction) {
        this.accountNumber = transaction.getAccountNumber();
        this.closingBalance = transaction.getClosingBalance();
        this.createDt = transaction.getCreateDt();
        this.customerId = transaction.getCustomerId();
        this.transactionAmt = transaction.getTransactionAmt();
        this.transactionDt = transaction.getTransactionDt();
        this.transactionId = transaction.getTransactionId();
        this.transactionSummary = transaction.getTransactionSummary();
        this.transactionType = transaction.getTransactionType();
    }

}
