package com.isa.service;


import com.isa.service.constant.ConstantValuesBean;
import com.isa.service.service.domain.EventService;
import com.isa.service.service.domain.OrganizerService;
import com.isa.service.service.domain.PlaceService;
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
    private OrganizerService organizerService;

    @Inject
    private ConstantValuesBean constantValuesBean;

    @Inject
    private GenerateRequest generateRequest;

    @Inject
    private PlaceService placeService;


    @PostConstruct
    public void apiInitialization() throws IOException {

        organizerService.setRelations(generateRequest.buildClientRequest(constantValuesBean.getOrganizersApi()));
        placeService.setRelations(generateRequest.buildClientRequest(constantValuesBean.getPlaceApi()));
        eventService.setRelationsToEntity(generateRequest.buildClientRequest(constantValuesBean.getEventsApi()));
    }
}
