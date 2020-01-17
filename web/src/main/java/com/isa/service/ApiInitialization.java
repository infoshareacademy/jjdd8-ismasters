package com.isa.service;


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

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    private EventManager eventManager;

    @Inject
    private OrganizersManager organizersManager;

    private final String eventsFile = ApiInitialization.class.getClassLoader().getResource("/events.json").getPath();
    private final String organizersFile = ApiInitialization.class.getClassLoader().getResource("/organizers.json").getPath();
    private final String placeFile = ApiInitialization.class.getClassLoader().getResource("/places.json").getPath();

    @PostConstruct
    public void apiInitialization() {

        try {
            organizersManager.setRelations(organizersFile);
            eventManager.setRelations(eventsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
