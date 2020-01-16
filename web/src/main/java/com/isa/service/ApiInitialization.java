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


    private static final String eventsFile = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/parser/events.json";
    private static final String organizersFile = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/parser/organizers.json";
    private static final String placesFile = "com/isa/parser/places.json";

    @PostConstruct
    public void apiInitialization() throws IOException {

        organizersManager.setRelations(organizersFile);
        eventManager.setRelations(eventsFile);

    }


}
