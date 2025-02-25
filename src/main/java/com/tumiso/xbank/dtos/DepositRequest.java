package com.tumiso.xbank.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class DepositRequest {

    @Valid

    @NotBlank(message = "Account number cannot be blank or null")
    @Pattern(regexp = "^\\d+$", message = "Account number can only contain digits")
    private String accountNumber;

    @NotBlank(message = "Reference must not be null or blank")
    @Size(min = 2, max = 50)
    private String reference;

    @NotBlank(message = "Amount cannot be blank or null")
    @Min(value = 10, message = "Amount must be at least 10.00")
    private Double amount;

}
