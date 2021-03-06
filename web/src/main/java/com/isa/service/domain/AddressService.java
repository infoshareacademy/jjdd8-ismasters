package com.isa.service.domain;

import com.isa.dao.AddressDao;
import com.isa.dao.PlaceDao;
import com.isa.domain.api.PlaceApi;
import com.isa.domain.entity.Address;
import com.isa.mapper.PlaceMapper;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Stateless
public class AddressService {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private AddressDao addressDao;

    @Inject
    private ApiDataParser apiDataParser;

    public void setRelationsAddress(String jsonString) throws IOException {
        List<PlaceApi> list = apiDataParser.parse(jsonString, PlaceApi.class);
        logger.debug("Zaimportowano listę lokalizacji ");
        for (PlaceApi e: list) {
            Address address = new Address();
            address.setLng(e.getAddressApi().getLng());
            address.setLat(e.getAddressApi().getLat());
            address.setZipcode(e.getAddressApi().getZipcode());
            address.setStreet(e.getAddressApi().getStreet());
            address.setCity(e.getAddressApi().getCity());

            addressDao.add(address);
            logger.debug("Adresy mapowane i kierowane do bazy danych");
        }
    }
}
