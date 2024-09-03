package com.spring.security.dto;


import com.spring.security.model.Accounts;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Schema(name = "Accounts", description = "Holds user account details")
public class AccountDTO {

    @Schema(description = "Unique Identifier of the account owner")
    private long customerId;

    @Schema(description = "Unique Identifier of the account")
    private long accountNumber;

    @Schema(description = "Type of the account")
    private String accountType;

    @Schema(description = "Physical location of the account")
    private String branchAddress;

    @Schema(description = "Creation Date of the account")
    private Date createDt;

    public AccountDTO(Accounts accounts) {
        this.accountNumber = accounts.getAccountNumber();
        this.accountType = accounts.getAccountType();
        this.branchAddress = accounts.getBranchAddress();
        this.createDt = accounts.getCreateDt();
        this.customerId = accounts.getCustomerId();
    }
}
