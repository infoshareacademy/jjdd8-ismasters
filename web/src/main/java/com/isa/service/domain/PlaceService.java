package com.isa.service.domain;

import com.isa.dao.AddressDao;
import com.isa.dao.PlaceDao;
import com.isa.domain.api.PlaceApi;
import com.isa.domain.entity.Address;
import com.isa.domain.entity.Place;
import com.isa.mapper.AddressMapper;
import com.isa.mapper.PlaceMapper;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Stateless
public class PlaceService {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private PlaceMapper placeMapper;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private AddressDao addressDao;

    @Inject
    private ApiDataParser apiDataParser;

    @Inject
    private AddressService addressService;

    @Inject
    private AddressMapper addressMapper;

    public void setRelations(String jsonString) throws IOException {

        List<PlaceApi> list = apiDataParser.parse(jsonString, PlaceApi.class);

        list.stream()
                .forEach(p ->{
                    Address address = new Address();
                    Place place = new Place();
                    address = addressMapper.mapApiViewToEntity(p.getAddressApi());
                    place = placeMapper.mapApiViewToEntity(p);
                    place.setAddress(address);
                    placeDao.addNewPlace(place);
                    logger.debug("Place {}",place );
                });

        logger.debug("Miejsce z adresem dodane do tabeli");

    }
}
