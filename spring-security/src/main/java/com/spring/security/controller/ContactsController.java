package com.spring.security.controller;

import com.spring.security.dto.ContactDTO;
import com.spring.security.dto.ErrorResponseDTO;
import com.spring.security.service.IContactService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "APIs to test Spring security concepts",
        description = " ")
@RequiredArgsConstructor
public class ContactsController {

    private final IContactService contactService;

    @Operation(summary = "Fetch Contact Details  REST API", description = "Fetch contact details")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @PostMapping()
    public ResponseEntity<List<ContactDTO>> saveContactInquiryDetails (ContactDTO contactDTO) {
        contactService.addContact(contactDTO);
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(contactService.getContacts());

    }

}
