package com.isa.service;

import com.isa.mock.EventDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SearchService {

    @EJB
    private EventService eventService;

    public List<EventDTO> searchEvents(String string) {
        return eventService.searchEvents(string);
    }
}
