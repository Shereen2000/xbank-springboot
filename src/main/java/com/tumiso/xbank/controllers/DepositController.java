package com.tumiso.xbank.controllers;

import com.tumiso.xbank.converters.DepositDtoConverter;
import com.tumiso.xbank.dtos.DepositRequest;
import com.tumiso.xbank.entities.Deposit;
import com.tumiso.xbank.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "xbank/deposit")
public class DepositController {

    private final DepositService depositService;
    private final DepositDtoConverter depositDtoConverter;

    @Autowired
    public DepositController(DepositService depositService, DepositDtoConverter depositDtoConverter)
    {
        this.depositDtoConverter = depositDtoConverter;
        this.depositService = depositService;
    }

    @GetMapping(path = "/{id}")
    public Deposit getDeposit(@PathVariable("id") Long id)
    {
        return depositService.getDepositById(id);
    }

    @GetMapping(path = "account-number/{accountNumber}")
    public List<Deposit> getDepositByAccountNumber(@PathVariable("accountNumber") String accountNumber)
    {
        return depositService.getDepositByAccountNumber(accountNumber);
    }

    @PostMapping
    public Deposit createDeposit(@RequestBody DepositRequest depositRequest)
    {
        Deposit deposit = depositDtoConverter.convertFromDepositRequest(depositRequest);
        return depositService.createDeposit(deposit);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteDeposit(@PathVariable("id") Long id)
    {
        depositService.deleteDepositById(id);
    }

}
