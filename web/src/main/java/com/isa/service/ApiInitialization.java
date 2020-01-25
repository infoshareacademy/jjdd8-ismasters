package com.isa.service;


import com.isa.service.constant.ConstantValuesBean;
import com.isa.service.domain.EventService;
import com.isa.service.domain.OrganizersService;
import com.isa.service.domain.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;

@Singleton
@Startup
public class ApiInitialization {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private EventService eventService;

    @Inject
    private OrganizersService organizersService;

    @Inject
    private ConstantValuesBean constantValuesBean;

    @Inject
    private ConverterRequest converter;

    @Inject
    private PlaceService placeService;


    @PostConstruct
    public void apiInitialization() throws IOException {

        organizersService.setRelations(converter.buildClientRequest(constantValuesBean.getOrganizersApi()));
        placeService.setRelations(converter.buildClientRequest(constantValuesBean.getPlaceApi()));
        eventService.mapApiToEntity(converter.buildClientRequest(constantValuesBean.getEventsApi()));
    }
}
