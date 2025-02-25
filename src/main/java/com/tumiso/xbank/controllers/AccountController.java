package com.tumiso.xbank.controllers;

import com.tumiso.xbank.converters.AccountDtoConverter;
import com.tumiso.xbank.dtos.AccountRequest;
import com.tumiso.xbank.entities.Account;
import com.tumiso.xbank.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "xbank/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountDtoConverter accountDtoConverter;

    @Autowired
    public AccountController(
            AccountService accountService
    ) {
        this.accountService = accountService;
        this.accountDtoConverter = new AccountDtoConverter();
    }


    @PostMapping
    public Account  createAccount(@RequestBody @Valid AccountRequest accountRequest )
    {
        Account account = accountDtoConverter.convertFromAccountRequest(accountRequest);
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAccounts()
    {
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/{id}")
    public Account getAccountById(@PathVariable("id") Long id)
    {
        return accountService.getAccountbyId(id);
    }

    @GetMapping(path = "account-number/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber)
    {
        return accountService.getbyAccountNumber(accountNumber);
    }

    @DeleteMapping(path ="/{id}")
    public void deleteAccount(@PathVariable("id") Long id)
    {
        accountService.deleteAccount(id);
    }


    @PutMapping(path = "/{id}")
    public Account updateAccount(@PathVariable("id") Long id, @RequestBody Account account)
    {
        return accountService.UpdateAccount(account, id);
    }

}
