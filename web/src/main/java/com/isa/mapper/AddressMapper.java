package com.isa.mapper;


import com.isa.domain.entity.Address;
import com.isa.domain.api.AddressApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class AddressMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public Address mapApiViewToEntity(AddressApi addressApi){
        logger.info("Address mapping to Entity");

        Address address = new Address();

        address.setStreet(addressApi.getStreet());
        address.setZipcode(addressApi.getZipcode());
        address.setCity(addressApi.getCity());
        address.setLat(address.getLat());
        address.setLng(addressApi.getLng());

        logger.info("Address mapping to Entity-> all parameters set");

        return address;
    }
}
