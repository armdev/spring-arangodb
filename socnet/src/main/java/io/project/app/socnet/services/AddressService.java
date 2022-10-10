/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.services;

import io.project.app.socnet.domain.Address;
import io.project.app.socnet.mappers.AddressCommand;

import io.project.app.socnet.repositories.AddressRepository;

import io.project.app.socnet.requests.AddressCreation;
import io.project.app.socnet.responses.AddressResponse;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressResponse setup(AddressCreation addressCreation) {
        Address addressCreation1 = AddressCommand.addressCreation(addressCreation);
        Address address = addressRepository.save(addressCreation1);
        return AddressCommand.toAddressResponse(address);
    }

    public Optional<AddressResponse> find(String id) {
        
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
       
            Address get = address.get();
                 log.info("Address is present " + get);
            return Optional.of(AddressCommand.toAddressResponse(get));
        }
        return Optional.empty();

    }

}
