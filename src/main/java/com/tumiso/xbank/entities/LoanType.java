package com.tumiso.xbank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Table(name = "loan_types")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanTypeId;

    private String name;

    private BigDecimal minimumAmount;

    private BigDecimal maximumAmount;

    private Integer minimumTermInMonths;

    private Integer maximumTermInMonths;

    private double minimumInterestRate;

    private double maximumInterestRate;
}
