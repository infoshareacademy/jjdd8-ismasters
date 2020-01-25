package com.isa.mapper;


import com.isa.domain.api.AddressApi;
import com.isa.domain.dto.AddressDto;
import com.isa.domain.entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class AddressMapper {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Address mapApiToEntity(AddressApi addressApi) {
        logger.debug("Address mapping to Entity");

        Address address = new Address();

        address.setStreet(addressApi.getStreet());
        address.setZipcode(addressApi.getZipcode());
        address.setCity(addressApi.getCity());
        address.setLat(address.getLat());
        address.setLng(addressApi.getLng());

        logger.debug("Address mapping to Entity-> all parameters set");

        return address;
    }

    public AddressDto mapEntityToDto(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setCity(address.getCity());
        addressDto.setId(address.getId());
        addressDto.setLat(address.getLat());
        addressDto.setLng(address.getLng());
        addressDto.setStreet(address.getStreet());
        addressDto.setZipcode(address.getZipcode());

        logger.debug("Address mapping to DTO -> all parameters are set");

        return addressDto;
    }
}
