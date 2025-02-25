package com.tumiso.xbank.controllers;

import com.tumiso.xbank.converters.WithdrawalDtoConverter;
import com.tumiso.xbank.dtos.WithdrawalRequest;
import com.tumiso.xbank.entities.Withdrawal;
import com.tumiso.xbank.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "xbank/withdrawal")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;
    private final WithdrawalDtoConverter withdrawalDtoConverter;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {

        this.withdrawalService = withdrawalService;
        this.withdrawalDtoConverter = new WithdrawalDtoConverter();
    }

    @PostMapping
    public Withdrawal createWithdrawal(@RequestBody WithdrawalRequest withdrawalRequest)
    {

        Withdrawal withdrawal = withdrawalDtoConverter.convertFromWithdrawalRequest(withdrawalRequest);
        return withdrawalService.createWithdrawal(withdrawal,withdrawalRequest.getPinCode());
    }

    @GetMapping(path = "/account-number/{accountNumber}")
    public List<Withdrawal> getWithdrawals(@PathVariable("accountNumber") String accountNumber)
    {
        return withdrawalService.getAllWithdrawalsByAccountNumber(accountNumber);
    }


    @GetMapping(path = "/{id}")
    public Withdrawal getWithdrawal(@PathVariable("id") Long id) {
        return withdrawalService.getWithdrawalById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteWithdrawal(@PathVariable("id") Long id)
    {
        withdrawalService.deleteWithdrawalById(id);
    }

}
