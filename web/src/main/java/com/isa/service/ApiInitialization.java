package com.isa.service;


import com.isa.service.constant.ConstantValuesBean;
import com.isa.service.manager.EventManager;
import com.isa.service.manager.OrganizersManager;
import com.isa.service.manager.PlaceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;

@Singleton
@Startup
public class ApiInitialization {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private EventManager eventManager;

    @Inject
    private OrganizersManager organizersManager;

    @Inject
    private ConstantValuesBean constantValuesBean;

    @Inject
    private ConverterRequest converter;

    @Inject
    private PlaceManager placeManager;


    @PostConstruct
    public void apiInitialization() throws IOException {

        organizersManager.setRelations(converter.buildClientRequest(constantValuesBean.getOrganizersApi()));
        placeManager.setRelations(converter.buildClientRequest(constantValuesBean.getPlaceApi()));
        eventManager.setRelations(converter.buildClientRequest(constantValuesBean.getEventsApi()));
    }
}
