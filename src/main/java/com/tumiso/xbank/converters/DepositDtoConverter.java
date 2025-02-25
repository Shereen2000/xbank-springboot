package com.tumiso.xbank.converters;

import com.tumiso.xbank.dtos.DepositRequest;
import com.tumiso.xbank.entities.Deposit;
import org.springframework.stereotype.Component;

@Component
public class DepositDtoConverter {

    public Deposit convertFromDepositRequest(DepositRequest depositRequest) {
        Deposit deposit = new Deposit();
        deposit.setAmount(depositRequest.getAmount());
        deposit.setAccountNumber(depositRequest.getAccountNumber());
        deposit.setReference(depositRequest.getReference());
        return deposit;
    }
}
