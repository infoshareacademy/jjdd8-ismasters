package com.isa.mapper;

import com.isa.domain.dto.PlaceDto;
import com.isa.domain.entity.Place;
import com.isa.domain.api.PlaceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class PlaceMapper {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());


    public Place mapApiViewToEntity(PlaceApi placeApi) {
        logger.debug("Place mapping to Entity");

        Place place = new Place();

        place.setApiId(placeApi.getApiId());
        place.setName(placeApi.getName());
        place.setSubName(placeApi.getDescription());

        logger.debug("Place mapping to Entity-> all parameters set");

        return place;
    }

    public PlaceDto mapApiViewToDto(Place place) {
        logger.debug("Place mapping to DTO");

        PlaceDto placeDto = new PlaceDto();

        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setSubname(place.getSubName());

        logger.debug("Place mapping to DTO-> all parameters set");

        return placeDto;
    }
}
