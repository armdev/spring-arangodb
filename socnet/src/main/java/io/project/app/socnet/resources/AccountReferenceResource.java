/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.socnet.resources;

import io.project.app.socnet.requests.AccountCreation;
import io.project.app.socnet.requests.AccountReferenceCreation;
import io.project.app.socnet.responses.AccountReferenceResponse;
import io.project.app.socnet.responses.AccountResponse;
import io.project.app.socnet.responses.RestApiResponse;
import io.project.app.socnet.services.AccountService;
import io.project.app.socnet.services.AddressReferenceService;
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
@RequestMapping("/api/v2/references")
@Slf4j
public class AccountReferenceResource {

    private final AddressReferenceService addressReferenceService;

    public AccountReferenceResource(AddressReferenceService addressReferenceService) {
        this.addressReferenceService = addressReferenceService;
    }

    @ApiResponses(value = {
        @ApiResponse()

    })
    @PostMapping(path = "/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setup(@RequestBody AccountReferenceCreation accountReferenceCreation) {
        AccountReferenceResponse accountReferenceResponse = addressReferenceService.setupReference(accountReferenceCreation.getAccountId(), accountReferenceCreation.getAddressId());
        return ResponseEntity.status(HttpStatus.CREATED).body(accountReferenceResponse);

    }

}
