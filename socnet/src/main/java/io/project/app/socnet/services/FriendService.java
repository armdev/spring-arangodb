/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.services;

import io.project.app.socnet.domain.Account;
import io.project.app.socnet.domain.Relation;
import io.project.app.socnet.mappers.AccountCommand;
import io.project.app.socnet.repositories.AccountRepository;
import io.project.app.socnet.repositories.RelationRepository;
import io.project.app.socnet.requests.AccountCreation;
import io.project.app.socnet.responses.AccountFriendResponse;
import io.project.app.socnet.responses.AccountReferenceResponse;
import io.project.app.socnet.responses.AccountResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class FriendService {

    private final AccountService accountService;

    private final RelationRepository relationRepository;

    public FriendService(AccountService accountService, RelationRepository relationRepository) {
        this.accountService = accountService;
        this.relationRepository = relationRepository;
    }

    @Transactional
    public AccountFriendResponse setup(String accountId, String friendId) {

        Optional<Relation> relationBetweenAccounts = relationRepository.findByFromIdAndToId(accountId, friendId);
        if (relationBetweenAccounts.isPresent()) {
            log.error("Relation already exist, exit");
            return new AccountFriendResponse();
        }

        Optional<Account> account = accountService.findEntity(accountId);

        Optional<Account> friend = accountService.findEntity(friendId);

        if (account.isPresent() && friend.isPresent()) {
            Account origin = account.get();
            Account target = friend.get();
            origin.getFriends().add(target);
            Account addFriend = accountService.addFriend(origin);
            Relation relation = new Relation();
            relation.setFrom(origin);
            relation.setTo(target);
            relationRepository.save(relation);
            return AccountCommand.toAccountResponseWithFriends(addFriend);
        }

        return new AccountFriendResponse();
    }

}
