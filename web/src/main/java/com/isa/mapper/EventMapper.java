package com.isa.mapper;


import com.isa.domain.dto.EventDto;
import com.isa.domain.entity.Event;
import com.isa.domain.api.EventApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class EventMapper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public Event mapApiViewToEntity(EventApi eventApiParser) {
        logger.info("Event mapping to Entity");

        Event event = new Event();

        event.setApiId(eventApiParser.getApi_Id());
        event.setStartDate(eventApiParser.getStartDate());
        event.setEndDate(eventApiParser.getEndDate());
        event.setDescShort(eventApiParser.getShortDescription());
        event.setName(eventApiParser.getName());
        event.setDescLong(eventApiParser.getLongDescription());
        event.setCategoryId(eventApiParser.getCategoryEventId());
        event.setActive(eventApiParser.getActiveEvent());

        logger.info("Event mapping to Entity -> all parameters are set");

        return event;
    }

    public EventDto mapApiViewToDto(Event eventEntity) {
        logger.info("Event mapping to DTO");

        EventDto eventDto = new EventDto();

        eventDto.setApiExternalId(eventEntity.getApiId());
        eventDto.setStartDate(eventEntity.getStartDate());
        eventDto.setEndDate(eventEntity.getEndDate());
        eventDto.setDescShort(eventEntity.getDescShort());
        eventDto.setName(eventEntity.getName());
        eventDto.setDescLong(eventEntity.getDescLong());
        eventDto.setCategoryId(eventEntity.getCategoryId());
        eventDto.setActive(eventEntity.isActive());

        logger.info("Event mapping to DTO -> all parameters are set");

        return eventDto;
    }

}
