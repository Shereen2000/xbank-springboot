package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByBankAccountNumber(Long BankAccountNumber);


}
