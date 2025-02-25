package com.tumiso.xbank.entities;

import com.tumiso.xbank.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transactions")
public class TransactionTrail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String accountNumber;

    public String transactionId;

    public TransactionType transactionType;

    public  double amount;

    public  double beforeBalance;

    public  double afterBalance;

}
