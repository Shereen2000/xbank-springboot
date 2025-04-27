package com.tumiso.xbank.entities;

import com.tumiso.xbank.entities.enums.status.BankAccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "bank_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Long AccountNumber;

    private Integer clientId;

    private Integer accountTypeId;

    private BigDecimal balance = BigDecimal.valueOf(0.00);

    @Enumerated(EnumType.STRING)
    private BankAccountStatus Status = BankAccountStatus.CREATED;

    private Instant createdAt = Instant.now();

    private Instant updatedAt = Instant.now();


    public void updateBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        this.updatedAt = Instant.now();
    }

}
