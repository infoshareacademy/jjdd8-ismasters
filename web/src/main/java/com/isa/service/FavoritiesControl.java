package com.isa.service;


import com.isa.domain.dto.EventDto;
import com.isa.service.domain.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class FavoritiesControl {


    @Inject
    private EventService eventService;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public boolean checkForFavEvent(long eventIdToCheck) {
        EventDto event = eventService.findById(eventIdToCheck);

        List<EventDto> eventfavDtoList = eventService.getAllFavEvents();

        for (EventDto e : eventfavDtoList) {
            if (event.equals(e)) {
                return true;
            }
        }
        return false;
    }

}
