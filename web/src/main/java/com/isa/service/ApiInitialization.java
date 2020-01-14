package com.isa.service;


import com.isa.dao.EventDao;
import com.isa.dao.PlaceDao;
import com.isa.domain.api.EventApi;
import com.isa.domain.entity.Event;
import com.isa.mapper.*;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Singleton
@Startup
public class ApiInitialization {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private AddressMapper addressMapper;

    @Inject
    private EventMapper eventMapper;

    @Inject
    private OrganizerMapper organizerMapper;

    @Inject
    private PlaceMapper placeMapper;

    @Inject
    private TicketMapper ticketMapper;

    @Inject
    private UrlMapper urlMapper;

    @Inject
    private EventDao eventDao;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private ApiDataParser apiDataParser;

    private static final String eventsFile = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/parser/events.json";
    private static final String organizersFile = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/parser/organizers.json";
    private static final String placesFile = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/parser/places.json";
    private static final String categoriesFile = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/parser/places.json";

    @PostConstruct
    public void importingEvents() throws IOException {
        List<EventApi> listOfEvents = apiDataParser.parse(eventsFile, EventApi.class);
        logger.info("Zaimportowano listę Wydarzeń");

        for (EventApi e :listOfEvents) {
            logger.info("Wydarzenia mapowane i kierowane do bazy danych");
            Event event = new Event();
            event = eventMapper.mapApiViewToEntity(e);
            eventDao.addNewEvent(event);
        }
    }
}
