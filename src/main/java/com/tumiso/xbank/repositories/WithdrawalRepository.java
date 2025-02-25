package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
    List<Withdrawal> findByAccountNumber(String accountNumber);
}
