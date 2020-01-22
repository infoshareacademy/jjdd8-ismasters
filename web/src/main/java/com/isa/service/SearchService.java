package com.isa.service;

import com.isa.domain.dto.EventDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SearchService {

    @EJB
    private EventService eventService;

    public List<EventDto> searchEvents(String string) {
        return eventService.searchEvents(string);
    }
}
