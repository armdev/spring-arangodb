/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.socnet.resources;

import io.project.app.socnet.domain.Account;
import io.project.app.socnet.services.AccountService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @ApiResponses(value = {
        @ApiResponse()

    })
    @PostMapping(path = "/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody Account requestData) {
        log.info("Registration started " + requestData.toString());
        Account registerAccount = accountService.setup(requestData);

        return ResponseEntity.status(HttpStatus.CREATED).body(registerAccount);

    }

}
