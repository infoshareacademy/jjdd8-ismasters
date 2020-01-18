package com.isa.mapper;

import com.isa.domain.entity.Place;
import com.isa.domain.api.PlaceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class PlaceMapper {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());


    public Place mapApiViewToEntity(PlaceApi placeApi) {
        logger.info("Place mapping to Entity");

        Place place = new Place();

        place.setApiId(placeApi.getApiId());
        place.setName(placeApi.getName());
        place.setSubName(placeApi.getDescription());

        logger.info("Place mapping to Entity-> all parameters set");

        return place;
    }
}
