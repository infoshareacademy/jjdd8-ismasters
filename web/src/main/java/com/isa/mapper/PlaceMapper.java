package com.isa.mapper;

import com.isa.domain.entity.Place;
import com.isa.parser.domain.PlaceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PlaceMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    public AddressMapper addressMapper;

    public Place mapApiViewToEntity(PlaceApi placeApi){
        logger.info("Place mapping to Entity");

        Place place = new Place();

        place.setApiId(placeApi.getApi_Id());
        place.setName(placeApi.getName());
        place.setSubName(placeApi.getDescription());
        place.setAddress(addressMapper.mapApiViewToEntity(placeApi.getAddressApi()));

        logger.info("Place mapping to Entity-> all parameters set");

        return place;
    }
}
