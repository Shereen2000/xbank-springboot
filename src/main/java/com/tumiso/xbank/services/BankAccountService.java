package com.tumiso.xbank.services;

import com.tumiso.xbank.entities.Account;
import org.springframework.stereotype.Service;

@Service
public interface BankAccountService {

    public Account getBankAccountByAccountNumber(Long bankAccountNumber);
}
