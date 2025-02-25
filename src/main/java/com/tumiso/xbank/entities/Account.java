package com.tumiso.xbank.entities;
import com.tumiso.xbank.entities.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clientName;

    private String clientSurname;

    @Column(unique=true)
    private String email;

    @Column(unique = true)
    private String accountNumber;

    private String pinCode;

    private LocalDateTime createdTimeStamp;

    private Double balance;

    private AccountStatus status;
}