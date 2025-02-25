package com.tumiso.xbank.entities;

import com.tumiso.xbank.entities.enums.TransferStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fromAccountNumber;

    private String toAccountNumber;

    private Double amount;

    private TransferStatus status;

}
