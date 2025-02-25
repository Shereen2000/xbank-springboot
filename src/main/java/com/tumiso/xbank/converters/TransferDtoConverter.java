package com.tumiso.xbank.converters;

import com.tumiso.xbank.dtos.TransferRequest;
import com.tumiso.xbank.entities.Transfer;
import org.springframework.stereotype.Component;

@Component
public class TransferDtoConverter {

    public Transfer convertFromTransferRequest(TransferRequest transferRequest) {
        Transfer transfer = new Transfer();

        transfer.setFromAccountNumber(transferRequest.getFromAccount());
        transfer.setToAccountNumber(transferRequest.getToAccount());
        transfer.setAmount(transferRequest.getAmount());
        return transfer;
    }
}
