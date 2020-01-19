package com.isa.web;

import com.isa.domain.dto.EventDto;
import com.isa.mapper.EventMapper;
import com.isa.service.EventService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 *
 */
@Path ("/events")
public class Event {

    @Inject
    private EventService eventService;

@Inject
private EventMapper eventMapper;

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<EventDto> eventDtoList = eventService.findAll();

        return Response.ok().entity(eventDtoList).build();
    }
}
