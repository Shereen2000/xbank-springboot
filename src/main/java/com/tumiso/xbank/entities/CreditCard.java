package com.tumiso.xbank.entities;

import com.tumiso.xbank.entities.enums.status.CreditCardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "credit_cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditCardId;

    private Long creditCardAccountNumber;

    private Integer clientProfileId;

    private BigDecimal creditLimit;

    private BigDecimal creditBalance;

    private double interestRate;

    private Instant dateIssued = Instant.now();

    private Instant dateUpdated;

    private CreditCardStatus status;

}
