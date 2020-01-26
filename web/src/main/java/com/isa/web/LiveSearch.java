package com.isa.web;



import com.isa.domain.dto.EventDto;
import com.isa.service.domain.EventService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/search")
public class LiveSearch {

    @EJB
    private EventService eventService;

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTitle(@PathParam("param") String param) {

        List<EventDto> eventDtoList = eventService.findByName(param);


        return Response.ok().entity(eventDtoList).build();
    }

}
