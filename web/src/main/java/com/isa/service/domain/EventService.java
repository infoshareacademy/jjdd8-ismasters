package com.isa.service.domain;

import com.isa.dao.EventDao;
import com.isa.dao.OrganizersDao;
import com.isa.dao.PlaceDao;
import com.isa.domain.api.EventApi;
import com.isa.domain.dto.EventDto;
import com.isa.domain.dto.OrganizerDto;
import com.isa.domain.dto.PlaceDto;
import com.isa.domain.dto.UrlDto;
import com.isa.domain.entity.Event;
import com.isa.domain.entity.Organizer;
import com.isa.domain.entity.Place;
import com.isa.domain.entity.Url;
import com.isa.mapper.EventMapper;
import com.isa.mapper.OrganizerMapper;
import com.isa.mapper.PlaceMapper;
import com.isa.mapper.UrlMapper;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class EventService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private EventMapper eventMapper;

    @Inject
    private EventDao eventDao;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private OrganizersDao organizersDao;

    @Inject
    private OrganizerMapper organizerMapper;

    @Inject
    private ApiDataParser apiDataParser;

    @Inject
    private UrlMapper urlMapper;

    @Inject
    private PlaceMapper placeMapper;

    public void setRelationsToEntity(String jsonString) throws IOException {

        List<EventApi> list = apiDataParser.parse(jsonString, EventApi.class);
        logger.info("Zaimportowano listę Wydarzeń");

        list.stream()
                .forEach(e -> {

                    Long externalOrganizerId = e.getOrganizerExternal().getId();
                    Organizer organizer = organizersDao.findByApiId(externalOrganizerId);
                    Event event = eventMapper.mapApiViewToEntity(e);

                    logger.debug("Organizer {},{}", externalOrganizerId, organizer);

                    event.setOrganizer(organizer);
                    Url url = urlMapper.mapApiViewToEntity(e.getWeblinkExternal());
                    event.setUrl(url);

                    int placeExternalId = e.getPlaceApi().getApiId();

                    Place place = placeDao.findByApiId(placeExternalId);
                    logger.debug("Place id {}, {}", placeExternalId, place);

                    event.setPlace(place);
                    logger.debug("Przed zapisem {}", event);

                    eventDao.addNewEvent(event);
                    logger.debug("Dodano do bazy {}", event);
                });

    }


    public EventDto setRelationsToDTO(Event event) {

        EventDto eventDto = new EventDto();

        eventDto = eventMapper.mapEntityToDto(event);

        OrganizerDto organizerDto = organizerMapper.mapApiViewToDto(event.getOrganizer());

        UrlDto urlDto = urlMapper.mapApiViewToDto(event.getUrl());

        PlaceDto placeDto = placeMapper.mapApiViewToDto(event.getPlace());

        logger.info("______________");
        logger.info("OrganizerDTO designation: {}", organizerDto.getDesignation());
        logger.info("OrganizerDTO eventDtoList(0): {}", Optional.ofNullable(organizerDto.getEventDtoList().get(0)));
        logger.info("OrganizerDTO idDb: {}", organizerDto.getIdDb());
        logger.info("OrganizerDTO idExternal: {}", organizerDto.getIdExternal());
        logger.info("______________");
        logger.info("Event getOrganizer {}", event.getOrganizer().getId());
        logger.info("URL getUrl {}", event.getUrl().getId());
        logger.info("Place getPlace {}", event.getPlace().getId());

        eventDto.setOrganizer(organizerDto);
        eventDto.setUrls(urlDto);
        eventDto.setPlace(placeDto);

        return eventDto;

    }


    public List<EventDto> findAll() {

        List<EventDto> eventDtoList = new ArrayList<>();

        eventDao.findAll()
                .forEach(event -> eventDtoList.add(setRelationsToDTO(event)));
        return eventDtoList;
    }

    public EventDto findById(Long id) {
        Event event = eventDao.findById(id).orElseThrow();
        return eventMapper.mapEntityToDto(event);
    }

    public List<EventDto> searchEvents(String search) {
        return eventDao.searchEvents(search).stream()
                .map((event -> eventMapper.mapEntityToDto(event)))
                .collect(Collectors.toList());
    }

    public List<EventDto> getEventsForView(int setStartEvent, int maxEvent) {

        return eventDao.getEventsForView(setStartEvent, maxEvent).stream().map(e -> setRelationsToDTO(e))
                .collect(Collectors.toList());
    }

}
