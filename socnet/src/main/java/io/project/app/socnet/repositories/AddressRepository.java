/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.socnet.repositories;

import com.arangodb.springframework.repository.ArangoRepository;
import io.project.app.socnet.domain.Address;

/**
 *
 * @author armena
 */
public interface AddressRepository extends ArangoRepository<Address, String> {

}
