package com.isa.web;


import com.isa.domain.dto.EventDto;
import com.isa.service.domain.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("/search")
public class LiveSearch {


    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private EventService eventService;

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTitle(@PathParam("param") String param,  @QueryParam("startDate") String startDate,  @QueryParam("endDate") String endDate) {
        List<EventDto> eventDtoList = new ArrayList<>();

        if (startDate.isEmpty()||endDate.isEmpty()){
            startDate = "12/31/2019";
            endDate = "02/20/2020";
        }

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        logger.info("startDate załadowane {}", startDate);
        logger.info("enddate załadowane {}", endDate);

        LocalDateTime localStartDate =  LocalDate.parse(startDate.replace("''", ""),formatter).atStartOfDay();
        LocalDateTime localEndDate =  LocalDate.parse(endDate.replace("''", ""),formatter).atStartOfDay();

        logger.info("startDate załadowane {}", startDate);

        logger.info("endDate załadowane {}", endDate);
        eventDtoList.addAll(eventService.findByNameRest(param, localStartDate, localEndDate));

        return Response.ok().entity(eventDtoList).build();
    }

}
