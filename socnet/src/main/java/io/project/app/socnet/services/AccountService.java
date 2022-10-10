/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.services;

import io.project.app.socnet.domain.Account;
import io.project.app.socnet.mappers.AccountCommand;
import io.project.app.socnet.repositories.AccountRepository;
import io.project.app.socnet.requests.AccountCreation;
import io.project.app.socnet.responses.AccountReferenceResponse;
import io.project.app.socnet.responses.AccountResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse setup(AccountCreation accountCreation) {
        Account accountCreationCommand = AccountCommand.accountCreation(accountCreation);
        Account account = accountRepository.save(accountCreationCommand);
        return AccountCommand.toAccountResponse(account);
    }

    public AccountReferenceResponse createReference(Account addAddress) {
        Account account = accountRepository.save(addAddress);
        return AccountCommand.toAccountReferenceResponse(account);
    }
    
     public Account addFriend(Account accountWithFriend) {
        Account account = accountRepository.save(accountWithFriend);
        return account;
    }
    
     public Optional<AccountReferenceResponse> findWithAddress(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account get = account.get();
            return Optional.of(AccountCommand.toAccountReferenceResponse(get));
        }
        return Optional.empty();
    }

    public Optional<AccountResponse> find(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account get = account.get();
            return Optional.of(AccountCommand.toAccountResponse(get));
        }
        return Optional.empty();
    }

    public Optional<Account> findEntity(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account get = account.get();
            return Optional.of(get);
        }
        return Optional.empty();
    }

    public List<AccountResponse> findAll() {
        List<Account> accountList = (List) accountRepository.findAll();

        return AccountCommand.toAccountResponseList(accountList);

    }

}
