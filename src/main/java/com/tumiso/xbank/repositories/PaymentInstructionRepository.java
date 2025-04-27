package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.PaymentInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInstructionRepository extends JpaRepository<PaymentInstruction,Integer> {
}
