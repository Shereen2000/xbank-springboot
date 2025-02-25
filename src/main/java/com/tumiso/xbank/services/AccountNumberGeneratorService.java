package com.tumiso.xbank.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountNumberGeneratorService {

    public AccountNumberGeneratorService() {
    }

    public String generateAccountNumber() {
        Random random = new Random();
        int firstDigit = random.nextInt(9) + 1;
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append(firstDigit);
        for (int i = 0; i < 7; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

}
