package com.tumiso.xbank.services;

import com.tumiso.xbank.entities.Account;
import com.tumiso.xbank.entities.enums.AccountStatus;
import com.tumiso.xbank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private AccountNumberGeneratorService accountNumberGeneratorService;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountNumberGeneratorService accountNumberGeneratorService) {

        this.accountRepository = accountRepository;
        this.accountNumberGeneratorService = accountNumberGeneratorService;
    }

    public Account createAccount(Account account)
    {
        account.setBalance(0.00);
        account.setAccountNumber(accountNumberGeneratorService.generateAccountNumber());
        account.setCreatedTimeStamp(LocalDateTime.now());
        account.setStatus(AccountStatus.ACTIVE);

        accountRepository.save(account);
       return account;
    }

    public List<Account> getAllAccounts()
    {
        return accountRepository.findAll();
    }

    public Account getAccountbyId(Long id) {

        return accountRepository.findById(id).orElseThrow(()->
                new IllegalStateException("Account of Id:"+id+" is not found"));

    }

    public Account getbyAccountNumber(String accountNumber) {
        Account existingAccount = accountRepository.findByAccountNumber(accountNumber);

        if (existingAccount == null) {
            throw new IllegalStateException("Account Number:"+accountNumber+
                    " is not found");
        }

        return existingAccount;
    }



    public Account UpdateAccount(Account account, Long id) {
        Account existingAccount = accountRepository.findById(id).orElseThrow(()->
                new IllegalStateException("Account of id:"+id+" is not found"));

        if(account.getPinCode() != null && account.getPinCode().length() > 0 &&
        !Objects.equals(existingAccount.getPinCode(), account.getPinCode()))
        {
            existingAccount.setPinCode(account.getPinCode());
        }

        if(!Objects.equals(existingAccount.getBalance(),account.getBalance())
                && account.getBalance() != null)
        {
            existingAccount.setBalance(account.getBalance());
        }

        if(existingAccount.getStatus() != account.getStatus() && account.getStatus() != null)
        {
            existingAccount.setStatus(account.getStatus());
        }

        accountRepository.save(existingAccount);
        return existingAccount;
    }

    public void deleteAccount(Long id) {
        Account existingAccount = accountRepository.findById(id).orElseThrow(()->
                new IllegalStateException("Account of Id:"+id+" is not found"));

        accountRepository.delete(existingAccount);
    }

}
