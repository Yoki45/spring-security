package com.spring.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "User", description = "Holds user details")
public class UserDTO {

    @Schema(name = "Email of the customer", example = "hjfh@gmail.com")
    @NotNull(message = "User name is required")
    private String username;
    @Schema(name = "Password of the customer", example = "1221kldfklig")
    @NotNull(message = "Password is required")
    private String password;
    @Schema(name = "Role of the customer", example = "1221kldfklig")
    @NotNull(message = "Role is required")
    private String role;

}
