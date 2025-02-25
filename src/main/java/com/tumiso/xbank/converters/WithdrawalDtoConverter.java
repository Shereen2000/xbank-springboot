package com.tumiso.xbank.converters;

import com.tumiso.xbank.dtos.WithdrawalRequest;
import com.tumiso.xbank.entities.Withdrawal;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class WithdrawalDtoConverter {

    public Withdrawal convertFromWithdrawalRequest(WithdrawalRequest withdrawalRequest) {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAccountNumber(withdrawalRequest.getAccountNumber());
        withdrawal.setAmount(withdrawalRequest.getAmount());
        withdrawal.setWithdrawTimeStamp(LocalDateTime.now());
        return withdrawal;
    }
}