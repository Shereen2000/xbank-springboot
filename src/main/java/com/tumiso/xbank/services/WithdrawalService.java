package com.tumiso.xbank.services;

import com.tumiso.xbank.entities.Account;
import com.tumiso.xbank.entities.Withdrawal;
import com.tumiso.xbank.entities.enums.AccountStatus;
import com.tumiso.xbank.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawalService {

    private WithdrawalRepository withdrawalRepository;
    private AccountService accountService;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepository, AccountService accountService) {
        this.withdrawalRepository = withdrawalRepository;
        this.accountService = accountService;
    }


    public Withdrawal createWithdrawal(Withdrawal withdrawal, String pinCode) {

        Account existingAccount = accountService.getbyAccountNumber(withdrawal.getAccountNumber());

        if(!(existingAccount.getStatus()== AccountStatus.ACTIVE)) {
            throw new IllegalStateException("Account: "+existingAccount.getAccountNumber()+" is "+ existingAccount.getStatus());
        }

        if(!existingAccount.getPinCode().equals(pinCode)) {
            throw new IllegalStateException("PIN code does not match");
        }

        if(withdrawal.getAmount()>existingAccount.getBalance()) {
            throw new IllegalStateException("Insufficient funds");
        }

            existingAccount.setBalance(existingAccount.getBalance()-withdrawal.getAmount());

            accountService.UpdateAccount(existingAccount, existingAccount.getId());

        return withdrawalRepository.save(withdrawal);
    }

    public List<Withdrawal> getAllWithdrawalsByAccountNumber(String accountNumber) {
        return withdrawalRepository.findByAccountNumber(accountNumber);
    }

    public Withdrawal getWithdrawalById(Long id) {
        return withdrawalRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Withdrawal of id:"+id+" not found"));

    }

    public void deleteWithdrawalById(Long id) {
        Withdrawal existingWithdrawal = withdrawalRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Withdrawal of id:"+id+" not found"));


        withdrawalRepository.delete(existingWithdrawal);
    }
}
