package com.tumiso.xbank.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TransferRequest {

    @NotBlank(message = "Account number cannot be blank or null")
    @Pattern(regexp = "^\\d+$", message = "Account number can only contain digits")
    private String fromAccount;

    @NotBlank(message = "Account number cannot be blank or null")
    @Pattern(regexp = "^\\d+$", message = "Account number can only contain digits")
    private String toAccount;

    @NotBlank(message = "Amount cannot be blank or null")
    @Min(value = 10, message = "Amount must be at least 10.00")
    private double amount;

    @NotBlank(message = "PinCode cannot be blank or null")
    @Size(min = 4, max = 4, message = "PinCode consists of 4 digits")
    @Pattern(regexp = "^\\d+$", message = "PinCode can only contain only digits")
    private String fromAccountPinCode;
}
