package com.tumiso.xbank.services;

import com.tumiso.xbank.entities.Account;
import com.tumiso.xbank.repositories.BankAccountRepository;

public class BankAccountServiceImp implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImp(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Account getBankAccountByAccountNumber(Long bankAccountNumber)
    {

        return bankAccountRepository.findByBankAccountNumber(bankAccountNumber).orElseThrow(() -> new
                RuntimeException("Bank account not found"));
    }
}
