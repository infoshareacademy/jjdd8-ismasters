package com.isa.Mapper;


import com.isa.domain.entity.Event;

import javax.ejb.Stateless;

@Stateless
public class EventMapper {


    public Event fromParserClassToEntity(com.isa.Parser.DomainClass.Event eventParser) {
        Event event = new Event();

        event.setApiId(eventParser.getApi_Id());
        event.setStartDate(eventParser.getStartDate());
        event.setEndDate(eventParser.getEndDate());
        event.setDescShort(eventParser.getShortDescription());
        event.setName(eventParser.getName());
        event.setDescLong(eventParser.getLongDescription());
        event.setCategoryId(eventParser.getCategoryEventId());
        event.setActive(eventParser.getActiveEvent());

        return event;
    }

}
