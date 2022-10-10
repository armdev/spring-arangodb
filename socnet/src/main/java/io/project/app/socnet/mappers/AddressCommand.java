package io.project.app.socnet.mappers;

import io.project.app.socnet.domain.Address;
import io.project.app.socnet.requests.AddressCreation;

import io.project.app.socnet.responses.AddressResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public class AddressCommand {

    public static Address addressCreation(AddressCreation input) {
        Address output = new Address();
        try {
            BeanUtils.copyProperties(input, output);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Address from AddressCreation", e);
        }
        return output;
    }

    public static AddressResponse toAddressResponse(Address input) {
        AddressResponse output = new AddressResponse();
        try {
            BeanUtils.copyProperties(input, output);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Address from AddressResponse", e);
        }
        return output;
    }

    public static List<AddressResponse> toAddressResponseList(List<Address> input) {
        List<AddressResponse> outputList = new ArrayList<>();
        AddressResponse output = new AddressResponse();
        try {
            for (Address sh : input) {
                output = new AddressResponse();
                BeanUtils.copyProperties(sh, output);
                outputList.add(output);
            }
        } catch (BeansException e) {
            throw new RuntimeException("Error creating List<AddressResponse> list from List<Address>", e);
        }
        return outputList;
    }

}
