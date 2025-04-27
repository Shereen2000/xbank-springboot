package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.CreditCard;
import com.tumiso.xbank.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

}
