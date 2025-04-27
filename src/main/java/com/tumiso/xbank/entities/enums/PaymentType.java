package com.tumiso.xbank.entities.enums;

import lombok.Getter;

@Getter
public enum  PaymentType {
    // Between same client's accounts
    OWN_ACCOUNT_TRANSFER("OAT"),           // e.g., savings to cheque

    // Payments to bank products
    LOAN_ACCOUNT_REPAYMENT("LOA"),                 // Paying off a bank loan

    CREDIT_CARD_PAYMENT("CRC"),          // Paying toward a credit card

    // Payments to another customer of the same bank
    INTERNAL_CLIENT_PAYMENT("INP"),      // e.g., paying another xBank client

    // Payments to another bank
    EXTERNAL_BANK_PAYMENT("EBP");           // e.g., from xBank to ABSA

    private final String abbreviation;

    PaymentType(String abbreviation1) {
        this.abbreviation = abbreviation1;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "abbreviation='"  + '\'' +
                '}';
    }
}
