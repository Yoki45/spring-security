package com.spring.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "User", description = "Holds user details")
public class UserDTO {

    @Schema(description = "Email of the customer", example = "hjfh@gmail.com")
    private String username;

    @Schema(description = "Password of the customer", example = "1221kldfklig")
    private String password;

    @Schema(description = "Role of the customer", example = "USER")
    private String role;

    @Schema(description = "Mobile phone number of the customer", example = "+1234567890")
    private String mobileNumber;

    @Schema(description = "Full name of the customer", example = "John Doe")
    private String name;


}
