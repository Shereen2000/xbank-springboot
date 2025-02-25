package com.tumiso.xbank.services;

import com.tumiso.xbank.entities.Account;
import com.tumiso.xbank.entities.Transfer;
import com.tumiso.xbank.entities.enums.TransferStatus;
import com.tumiso.xbank.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    private final TransferRepository transferRepository;
    private final AccountService accountService;

    @Autowired
    public TransferService(TransferRepository transferRepository, AccountService accountService) {
        this.transferRepository = transferRepository;
        this.accountService = accountService;
    }


    public Transfer createTransfer(Transfer transfer, String fromAccountPinCode) {

        transfer.setStatus(TransferStatus.PENDING);

        Account fromAccount = accountService.getbyAccountNumber(transfer.getFromAccountNumber());
        Account toAccount = accountService.getbyAccountNumber(transfer.getToAccountNumber());

        if(!fromAccount.getPinCode().equals(fromAccountPinCode)) {
            throw new IllegalStateException("PIN code does not match");
        }

        if(transfer.getAmount()>fromAccount.getBalance()) {
            throw new IllegalStateException("Insufficient funds");
        }

        if(transfer.getAmount()<10.0)
        {
            throw new IllegalStateException("Minimum transfer is 10.00");
        }

        fromAccount.setBalance(fromAccount.getBalance()-transfer.getAmount());
        accountService.UpdateAccount(fromAccount, fromAccount.getId());

        return transferRepository.save(transfer);

    }


    public Transfer updateTransfer(Transfer transfer, Long id) {


        Transfer existingTransfer = transferRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Transfer of id:"+id+" not found"));

        if(existingTransfer.getStatus() == TransferStatus.PENDING && transfer.getStatus() != existingTransfer.getStatus() )
        {
            existingTransfer.setStatus(transfer.getStatus());

            if(existingTransfer.getStatus() == TransferStatus.APPROVED)
            {
                Account toAccount = accountService.getbyAccountNumber(existingTransfer.getToAccountNumber());
                toAccount.setBalance(toAccount.getBalance()+existingTransfer.getAmount());
                accountService.UpdateAccount(toAccount, toAccount.getId());
            }
            else if(existingTransfer.getStatus() == TransferStatus.REVERTED)
            {
                Account fromAccount = accountService.getbyAccountNumber(existingTransfer.getFromAccountNumber());
                fromAccount.setBalance(fromAccount.getBalance()+existingTransfer.getAmount());
                accountService.UpdateAccount(fromAccount, fromAccount.getId());
            }

        }

        return transferRepository.save(existingTransfer) ;
    }


    public Transfer getTransferById(Long id) {
        return transferRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Transfer of id:"+id+" not found")
        );
    }

    public List<Transfer> getTransfersByFromAccountNumber(String fromAccountNumber) {
        return transferRepository.findByFromAccountNumber(fromAccountNumber);
    }

    public List<Transfer> getTransfersByToAccountNumber(String toAccountNumber) {
        return transferRepository.findByToAccountNumber(toAccountNumber);
    }

    public List<Transfer> getTransferByFromAccountNumberAndToAccountNumber(String fromAccountNumber, String toAccountNumber) {
        return transferRepository.findByFromAccountNumberAndToAccountNumber(fromAccountNumber, toAccountNumber);
    }

    public void deleteTransferById(Long id) {
        Transfer existingTransfer = transferRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Transfer of id:"+id+" not found")
        );

        if(existingTransfer.getStatus() == TransferStatus.PENDING)
        {
           throw  new IllegalStateException("Cannot delete transfer of id:"+id+" because it is PENDING");
        }

        transferRepository.delete(existingTransfer);
    }


}
