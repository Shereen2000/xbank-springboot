package com.tumiso.xbank.utils;

import java.util.Random;

public class AccountNumberGenerator {

    private static final Random random = new Random();

    public static String generateAccountNumber()
    {
        StringBuilder accountNumber = new StringBuilder();

        accountNumber.append(random.nextInt(9) + 1);

        for (int i = 0; i < 9; i++) {
            accountNumber.append(random.nextInt(10));
        }

        return accountNumber.toString();
    }



}
