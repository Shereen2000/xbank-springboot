package com.tumiso.xbank.entities;

import com.tumiso.xbank.entities.enums.Bank;
import com.tumiso.xbank.entities.enums.PaymentRecurrenceType;
import com.tumiso.xbank.entities.enums.PaymentType;
import com.tumiso.xbank.entities.enums.status.TransactionInstructionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment_instructions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class PaymentInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentInstructionId;

    private PaymentType paymentType;

    private String payerAccountNumber;
    private Bank payerBank;

    private String beneficiaryAccountNumber;
    private Bank beneficiaryBank;

    private String referenceNumber;
    private String referenceDescription;

    private BigDecimal amount;


    //This section deals with the occurrence of the payment instruction_________________________

    private Boolean recurring;

    private Date recurringStartDate;

    private Date recurringEndDate;

    private PaymentRecurrenceType recurrenceType;

    private Integer recurringFixedDayOfMonth;
    //or
    private Integer recurringFrequencyInDays;

    private Integer numberOfOccurrences;

    //___________________________________________________________________________________________


    private Integer paymentsExecuted;

    private Date lastPaymentDate;

    private Date nextPaymentDate;


    private TransactionInstructionStatus status;

}