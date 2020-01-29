package com.isa.web;



import com.isa.domain.dto.EventDto;
import com.isa.service.domain.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.Month;
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
    public Response getTitle(@PathParam("param") String param,@DefaultValue("") @QueryParam("startDate") String startDate,@DefaultValue("") @QueryParam("endDate") String endDate) {
        List<EventDto> eventDtoList = new ArrayList<>();

        logger.info("startDate załadowane {}", startDate);
    /*    if (startDate == null && endDate== null){

            String startDateDefault = "2020-01-06T18:00:00+0100";
                    //String.valueOf(LocalDateTime.of(2017, Month.FEBRUARY,3,6,30,40,50000));
            logger.info("startDate załadowane");
            String endDateDefault = "2020-02-06T18:00:00+0100";
            //String.valueOf(LocalDateTime.of(2021, Month.FEBRUARY,3,6,30,40,50000));
            logger.info("endDate załadowane");
*/

        logger.info("endDate załadowane {}", endDate);
            eventDtoList.addAll(eventService.findByNameRest(param,startDate,endDate));


        return Response.ok().entity(eventDtoList).build();
    }

}
