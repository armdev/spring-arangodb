/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.socnet.resources;

import io.project.app.socnet.requests.AddressCreation;
import io.project.app.socnet.responses.AccountResponse;

import io.project.app.socnet.responses.AddressResponse;
import io.project.app.socnet.responses.RestApiResponse;

import io.project.app.socnet.services.AddressService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v2/address")
@Slf4j
public class AddressResource {

    private final AddressService addressService;

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @ApiResponses(value = {
        @ApiResponse()

    })
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setup(@RequestBody AddressCreation requestData) {
        log.info("Registration started " + requestData.toString());
        AddressResponse registerAccount = addressService.setup(requestData);

        return ResponseEntity.status(HttpStatus.CREATED).body(registerAccount);

    }

    @GetMapping(path = "/find")
    public ResponseEntity find(@RequestParam String id) {
        log.info("Start find with id " + id);
        Optional<AddressResponse> address = addressService.find(id);
        if (address.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(address.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestApiResponse("Did not find address"));

    }

    @ApiResponses(value = {
        @ApiResponse()

    })
    @GetMapping(path = "/find/all")
    public ResponseEntity all() {
        List<AddressResponse> addressList = addressService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(addressList);

    }

}
