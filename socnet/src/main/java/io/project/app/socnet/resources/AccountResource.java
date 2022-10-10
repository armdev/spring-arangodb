/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.socnet.resources;

import io.project.app.socnet.requests.AccountCreation;
import io.project.app.socnet.responses.AccountReferenceResponse;
import io.project.app.socnet.responses.AccountResponse;
import io.project.app.socnet.responses.RestApiResponse;
import io.project.app.socnet.services.AccountService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @ApiResponses(value = {
        @ApiResponse()

    })
    @PostMapping(path = "/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setup(@RequestBody AccountCreation requestData) {
        log.info("Registration started " + requestData.toString());
        AccountResponse registerAccount = accountService.setup(requestData);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerAccount);

    }

    @ApiResponses(value = {
        @ApiResponse()

    })
    @GetMapping(path = "/account")
    public ResponseEntity find(@RequestParam String id) {

        Optional<AccountResponse> account = accountService.find(id);

        if (account.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(account.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestApiResponse("Did not find account"));

    }

    @ApiResponses(value = {
        @ApiResponse()

    })
    @GetMapping(path = "/account/address")
    public ResponseEntity findAndAddress(@RequestParam String id) {

        Optional<AccountReferenceResponse> account = accountService.findWithAddress(id);

        if (account.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(account.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestApiResponse("Did not find account"));

    }

    @ApiResponses(value = {
        @ApiResponse()

    })
    @GetMapping(path = "/account/all")
    public ResponseEntity all() {
        List<AccountResponse> accountList = accountService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(accountList);

    }

}
