package com.spring.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
@Schema(name = "Contacts", description = "Holds user contact details")
public class ContactDTO {

    @Schema(description = "Unique Identifier of the contact information")
    private String contactId;

    @Schema(description = "Name of the person who is contacting")
    private String contactName;

    @Schema(description = "Email address of the person who is contacting")
    private String contactEmail;

    @Schema(description = "Subject of the contact message")
    private String subject;

    @Schema(description = "The content of the contact message")
    private String message;

    @Schema(description = "Date when the contact information was created")
    private Date createDt;

}
