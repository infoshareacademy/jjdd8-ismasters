package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.dao.OrganizersDao;
import com.isa.dao.PlaceDao;
import com.isa.dao.UrlDao;
import com.isa.domain.api.EventApi;
import com.isa.domain.entity.*;
import com.isa.mapper.EventMapper;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Stateless
public class EventManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private EventMapper eventMapper;

    @Inject
    private EventDao eventDao;

    @Inject
    private User user;

    @Inject
    private TicketType ticketType;

    @Inject
    private Organizer organizer;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private UrlDao urlDao;

    @Inject
    private OrganizersDao organizersDao;

    @Inject
    private ApiDataParser apiDataParser;

    
    public void setRelations(String filename) throws IOException {
        List<EventApi> list = apiDataParser.parse(filename, EventApi.class);
        logger.info("Zaimportowano listę Wydarzeń");
        for (EventApi e: list) {
            Event event = new Event();
            event = eventMapper.mapApiViewToEntity(e);
            event.setOrganizer(organizersDao.findByApiId(e.getApi_Id()));
            event.setUrl(urlDao.findByWWW(e.getWeblinkApi().getWebsite()));
            event.setPlace(placeDao.findByApiId(e.getPlaceApi().getApi_Id()));
            logger.info("Wydarzenia mapowane i kierowane do bazy danych");
            eventDao.addNewEvent(event);
        }
    }
}
