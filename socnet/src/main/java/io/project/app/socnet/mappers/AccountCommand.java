package io.project.app.socnet.mappers;

import io.project.app.socnet.domain.Account;
import io.project.app.socnet.requests.AccountCreation;
import io.project.app.socnet.responses.AccountFriendResponse;
import io.project.app.socnet.responses.AccountReferenceResponse;
import io.project.app.socnet.responses.AccountResponse;
import io.project.app.socnet.responses.Friend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public class AccountCommand {

    public static Account accountCreation(AccountCreation input) {
        Account output = new Account();
        try {
            BeanUtils.copyProperties(input, output);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Account from AccountCreation", e);
        }
        return output;
    }

    public static AccountFriendResponse toAccountResponseWithFriends(Account input) {
        AccountFriendResponse output = new AccountFriendResponse();
        try {
            BeanUtils.copyProperties(input, output);
            Friend ff = new Friend();
            for (Account friend : input.getFriends()) {
                ff = new Friend();
                ff.setId(friend.getId());
                ff.setName(friend.getName());
                output.getFriendList().add(ff);
            }
           
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Account from Account", e);
        }
        return output;
    }

    public static AccountResponse toAccountResponse(Account input) {
        AccountResponse output = new AccountResponse();
        try {
            BeanUtils.copyProperties(input, output);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Account from Account", e);
        }
        return output;
    }

    public static AccountReferenceResponse toAccountReferenceResponse(Account input) {
        AccountReferenceResponse output = new AccountReferenceResponse();
        try {
            if (input.getAddress() != null) {
                output.setAddressArangoId(input.getAddress().getArangoId());
                output.setAddressName(input.getAddress().getAddress());
            } else {
                output.setAddressArangoId("empty");
                output.setAddressName("emtpy");
            }

            BeanUtils.copyProperties(input, output);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Account from Account", e);
        }
        return output;
    }

    public static List<AccountResponse> toAccountResponseList(List<Account> input) {
        List<AccountResponse> outputList = new ArrayList<>();
        AccountResponse output = new AccountResponse();
        try {
            for (Account sh : input) {
                output = new AccountResponse();
                BeanUtils.copyProperties(sh, output);
                outputList.add(output);
            }
        } catch (BeansException e) {
            throw new RuntimeException("Error creating List<AccountModel> list from List<Account>", e);
        }
        return outputList;
    }

}
