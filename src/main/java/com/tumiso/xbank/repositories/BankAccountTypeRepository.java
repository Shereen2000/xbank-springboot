package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountTypeRepository  extends JpaRepository<AccountType,Integer> {

}
