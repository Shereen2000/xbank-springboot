package com.tumiso.xbank.entities;
import com.tumiso.xbank.entities.enums.status.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "payment_transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PaymentTransactionId;

    private Integer PaymentInstructionId;

    private Instant CreatedAt;

    private TransactionStatus status;

    private Instant LastStatusUpdate;

}
