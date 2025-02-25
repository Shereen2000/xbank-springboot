package com.tumiso.xbank.services;

import com.tumiso.xbank.entities.Account;
import com.tumiso.xbank.entities.Deposit;
import com.tumiso.xbank.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepositService {

    private final AccountService accountService;
    private final DepositRepository depositRepository;

    @Autowired
    public DepositService(
            AccountService accountService,
            DepositRepository depositRepository) {
        this.accountService = accountService;
        this.depositRepository = depositRepository;
    }

    public Deposit createDeposit(Deposit deposit) {
        Account account = accountService.getbyAccountNumber(deposit.getAccountNumber());
        account.setBalance(account.getBalance() + deposit.getAmount());
        accountService.UpdateAccount(account,account.getId());
        deposit.setDepositTimeStamp(LocalDateTime.now());
        return depositRepository.save(deposit);
    }

    public List<Deposit> getDepositByAccountNumber(String accountNumber) {
        Account account = accountService.getbyAccountNumber(accountNumber);
        return depositRepository.findByAccountNumber(account.getAccountNumber());
    }

    public Deposit getDepositById(Long id) {
        return depositRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Deposit of id:"+id+" not found"));
    }

    public void deleteDepositById(Long id) {
        Deposit existingDeposit = depositRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Deposit of id:"+id+" not found")
        );

        depositRepository.delete(existingDeposit);
    }
}
