package com.isa.mapper;


import com.isa.domain.dto.EventDto;
import com.isa.domain.entity.Event;
import com.isa.domain.api.EventApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class EventMapper {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Event mapApiToEntity(EventApi eventApiParser) {
        logger.debug("Event mapping to Entity");

        Event event = new Event();

        event.setApiId(eventApiParser.getApiId());
        event.setStartDate(eventApiParser.getStartDate());
        event.setEndDate(eventApiParser.getEndDate());
        event.setDescShort(eventApiParser.getShortDescription());
        event.setName(eventApiParser.getName());
        event.setDescLong(eventApiParser.getLongDescription());
        event.setCategoryId(eventApiParser.getCategoryEventId());
        event.setActive(eventApiParser.getActiveEvent());

        logger.debug("Event mapping to Entity -> all parameters are set");

        return event;
    }

    public EventDto mapEntityToDto(Event eventEntity) {
        logger.debug("Event mapping to DTO");

        EventDto eventDto = new EventDto();

        eventDto.setId(eventEntity.getId());
        eventDto.setApiExternalId(eventEntity.getApiId());
        eventDto.setStartDate(eventEntity.getStartDate());
        eventDto.setEndDate(eventEntity.getEndDate());
        eventDto.setDescShort(eventEntity.getDescShort());
        eventDto.setName(eventEntity.getName());
        eventDto.setDescLong(eventEntity.getDescLong());
        eventDto.setCategoryId(eventEntity.getCategoryId());
        eventDto.setActive(eventEntity.isActive());
//        eventDto.setAttachments(eventEntity.getAttachments());

        logger.debug("Event mapping to DTO -> all parameters are set");

        return eventDto;
    }

}
