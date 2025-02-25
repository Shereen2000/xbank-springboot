package com.tumiso.xbank.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountRequest {

    @Valid

    @NotBlank(message = "ClientName must not be null or blank")
    @Size(min = 2, max = 50)
    private String ClientName;

    @NotBlank(message = "ClientSurname must not be null or blank")
    @Size(min = 2, max = 50)
    private String ClientSurname;

    @Email
    @NotBlank(message = "email cannot be blank or null")
    private String email;

    @NotBlank(message = "PinCode must not be null or blank")
    @Size(min = 4, max = 4)
    @Pattern(regexp = "^\\d+$", message = "Pincode must contain only digits")
    private String PinCode;

}
