package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
    List<Deposit> findByAccountNumber(String accountNumber);
    List<Deposit> findByReference(String reference);
}
