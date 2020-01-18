package com.isa.web;


import com.isa.service.EventService;

import javax.ejb.EJB;
import javax.ws.rs.Path;

@Path("/api")
public class Application {

    @EJB
    private EventService eventService;


}
