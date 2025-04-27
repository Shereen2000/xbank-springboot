package com.tumiso.xbank.entities;

import com.tumiso.xbank.entities.enums.status.BankAccountTypeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTypeId;  // Unique identifier for the account type

    private String name;  // Name of the account type (e.g., "Savings", "Cheque", "Student")

    @Column(unique = true, nullable = false)
    private String abbreviation;

    private BigDecimal monthlyFee;  // Monthly fee for the account type (if any)

    private BigDecimal minimumBalance;  // Minimum balance required for this account type

    private BigDecimal overdraftLimit;

    private BigDecimal interestRate;  // Interest rate for this account type (e.g., savings)

    private Instant effectiveStartDate;  // The date the account type became effective

    private Instant effectiveEndDate;  // The date the account type is no longer effective (optional)

    @Enumerated(EnumType.STRING)
    private BankAccountTypeStatus status;  // The status of the account type

    private Boolean allowsOverdraft;  // Whether this account type allows overdraft functionality

    private Boolean isRecurringPaymentAllowed;  // Whether recurring payments are allowed for this account type

    private Instant createdAt;  // When the account type was created

    private Instant updatedAt;  // When the account type was last updated

}
