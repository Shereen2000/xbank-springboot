package com.tumiso.xbank.converters;

import com.tumiso.xbank.dtos.AccountRequest;
import com.tumiso.xbank.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {
    public  Account convertFromAccountRequest(AccountRequest accountRequest) {
        Account account = new Account();
        account.setPinCode(accountRequest.getPinCode());
        account.setClientName(accountRequest.getClientName());
        account.setClientSurname(accountRequest.getClientSurname());
        account.setEmail(accountRequest.getEmail());
        return account;
    }
}
