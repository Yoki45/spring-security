package com.spring.security.dto;

import com.spring.security.model.Loans;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
@Schema(name = "Loans", description = "Holds user Loan details")
public class LoansDTO {

    @Schema(description = "Unique Identifier of the user's loan")
    private long loanNumber;

    @Schema(description = "Unique Identifier of the customer associated with the loan")
    private long customerId;

    @Schema(description = "The date when the loan started")
    private Date startDt;

    @Schema(description = "Type of loan (e.g., Mortgage, Personal, Auto)")
    private String loanType;

    @Schema(description = "Total amount of the loan")
    private int totalLoan;

    @Schema(description = "Total amount that has been paid towards the loan")
    private int amountPaid;

    @Schema(description = "The remaining amount of the loan that is yet to be paid")
    private int outstandingAmount;

    @Schema(description = "Date when the loan record was created")
    private Date createDt;

    public LoansDTO(Loans loans) {
        this.amountPaid = loans.getAmountPaid();
        this.createDt = loans.getCreateDt();
        this.customerId = loans.getCustomerId();
        this.loanNumber = loans.getLoanNumber();
        this.loanType = loans.getLoanType();
        this.outstandingAmount = loans.getOutstandingAmount();
        this.startDt = loans.getStartDt();
        this.totalLoan = loans.getTotalLoan();
    }
}
