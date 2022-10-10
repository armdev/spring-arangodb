/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.services;

import io.project.app.socnet.domain.Account;
import io.project.app.socnet.mappers.AccountCommand;
import io.project.app.socnet.repositories.AccountRepository;
import io.project.app.socnet.requests.AccountCreation;
import io.project.app.socnet.responses.AccountResponse;
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

    public Optional<AccountResponse> find(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account get = account.get();
            return Optional.of(AccountCommand.toAccountResponse(get));
        }
        return Optional.empty();

    }

}
