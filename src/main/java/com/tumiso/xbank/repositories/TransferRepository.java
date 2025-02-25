package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    public List<Transfer> findByFromAccountNumber(String fromAccountNumber);
    public List<Transfer> findByToAccountNumber(String toAccountNumber);
    public List<Transfer> findByFromAccountNumberAndToAccountNumber(String fromAccountNumber, String toAccountNumber);
}
