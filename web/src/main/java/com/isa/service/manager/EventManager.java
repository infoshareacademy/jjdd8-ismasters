package com.isa.service.manager;

import com.isa.dao.EventDao;
import com.isa.dao.OrganizersDao;
import com.isa.dao.PlaceDao;
import com.isa.dao.UrlDao;
import com.isa.domain.api.EventApi;
import com.isa.domain.entity.*;
import com.isa.mapper.EventMapper;
import com.isa.mapper.UrlMapper;
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
    private PlaceDao placeDao;

    @Inject
    private UrlDao urlDao;

    @Inject
    private OrganizersDao organizersDao;

    @Inject
    private ApiDataParser apiDataParser;

    @Inject
    private UrlManager urlManager;

    @Inject
    private UrlMapper urlMapper;

    public void setRelations(String jsonString) throws IOException {
        /*urlManager.setRelationsUrl(jsonString);*/

        List<EventApi> list = apiDataParser.parse(jsonString, EventApi.class);
        logger.info("Zaimportowano listę Wydarzeń");

        list.stream()
                .forEach(e->{

                    Long externalOrganizerId = e.getOrganizerExternal().getId();
                    Organizer organizer = organizersDao.findByApiId(externalOrganizerId);
                    Event event = eventMapper.mapApiViewToEntity(e);
                    logger.info("Organizer {},{}",externalOrganizerId,organizer);
                    event.setOrganizer(organizer);
                    Url url = urlMapper.mapApiViewToEntity(e.getWeblinkExternal());
                    event.setUrl(url);
                    int placeExternalId = e.getPlaceApi().getApi_Id();

                    Place place = placeDao.findByApiId(placeExternalId);
                    logger.info("Place id {}, {}", placeExternalId, place);

                    event.setPlace(place);
                    logger.info("Przed zapisem {}", event);
                    eventDao.addNewEvent(event);
                    logger.info("Dodano do bazy {}", event);
                });

        /*for (EventApi e: list) {
            Event event = new Event();
            event = eventMapper.mapApiViewToEntity(e);
            event.setOrganizer(organizersDao.findByApiId(e.getOrganizerExternal().getId()));
            event.setUrl(urlDao.findByWWW(e.getWeblinkExternal().getWebsite()));
            event.setPlace(placeDao.findByApiId(e.getPlaceApi().getApi_Id()));
            logger.info("Wydarzenia mapowane i kierowane do bazy danych");
            eventDao.addNewEvent(event);
        }*/
    }
}
