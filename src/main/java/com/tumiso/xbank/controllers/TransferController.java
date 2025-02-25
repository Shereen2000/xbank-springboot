package com.tumiso.xbank.controllers;

import com.tumiso.xbank.converters.TransferDtoConverter;
import com.tumiso.xbank.dtos.TransferRequest;
import com.tumiso.xbank.entities.Transfer;
import com.tumiso.xbank.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "xbank/transfer")
public class TransferController {

    private final TransferService transferService;
    private final TransferDtoConverter transferDtoConverter;

    @Autowired
    public TransferController(TransferService transferService, TransferDtoConverter transferDtoConverter) {
        this.transferService = transferService;
        this.transferDtoConverter = transferDtoConverter;
    }

    @GetMapping(path = "/account-number/from/{accountNumber}")
    public List<Transfer> getTransfersByFromAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return transferService.getTransfersByFromAccountNumber(accountNumber);
    }

    @GetMapping(path = "/account-number/to/{accountNumber}")
    public List<Transfer> getTransfersByToAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return transferService.getTransfersByToAccountNumber(accountNumber);
    }

    @GetMapping(path = "/{id}")
    public Transfer getTransferById(@PathVariable("id") Long id) {
        return transferService.getTransferById(id);
    }

    @GetMapping(path = "/account-number/from/{fromAccountNumber}/to/{toAccountNumber}")
    public List<Transfer>  getTransferByFromAccountNumberAndToAccountNumber(@PathVariable("fromAccountNumber") String fromAccountNumber,
                                                                            @PathVariable("toAccountNumber") String toAccountNumber)
    {
        return transferService.getTransferByFromAccountNumberAndToAccountNumber(fromAccountNumber, toAccountNumber);
    }

    @PostMapping
    public Transfer createTransfer(@RequestBody TransferRequest transferRequest)
    {
        Transfer transfer = transferDtoConverter.convertFromTransferRequest(transferRequest);
        return transferService.createTransfer(transfer, transferRequest.getFromAccountPinCode());
    }

    @PutMapping(path = "/{id}")
    public Transfer updateTransfer(@PathVariable("id") Long id, @RequestBody Transfer transfer)
    {
        return transferService.updateTransfer(transfer, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTransfer(@PathVariable("id") Long id)
    {
        transferService.deleteTransferById(id);
    }

}
