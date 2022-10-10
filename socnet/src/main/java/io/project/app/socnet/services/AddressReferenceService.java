/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.services;

import io.project.app.socnet.domain.Account;
import io.project.app.socnet.domain.Address;
import io.project.app.socnet.mappers.AddressCommand;
import io.project.app.socnet.responses.AccountReferenceResponse;

import io.project.app.socnet.responses.AddressResponse;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class AddressReferenceService {

    private final AccountService accountService;

    private final AddressService addressService;

    public AddressReferenceService(AccountService accountService, AddressService addressService) {
        this.accountService = accountService;
        this.addressService = addressService;
    }

    public AccountReferenceResponse setupReference(@NotNull final String accountId, @NotNull final String addressId) {

        Optional<Account> account = accountService.findEntity(accountId);

        Optional<Address> address = addressService.findEntity(addressId);

        if (account.isPresent() && address.isPresent()) {
            Account existingAccount = account.get();
            Address existingAddress = address.get();
            existingAccount.setAddress(existingAddress);
            return accountService.createReference(existingAccount);

        }

        return new AccountReferenceResponse();
    }

}
