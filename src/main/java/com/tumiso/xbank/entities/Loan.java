package com.tumiso.xbank.entities;

import com.tumiso.xbank.entities.enums.InterestRateType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "loans")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private Long loanAccountNumber;

    private Integer clientProfileId;

    private Integer loanTypeId;

    private BigDecimal principal;

    private BigDecimal balance;

    private double interestRate;

    @Enumerated(EnumType.STRING)
    private InterestRateType interestRateType;

    private int termInMonths;

    private Date paymentDate;

    private Date startDate;

    private Date endDate;

}
