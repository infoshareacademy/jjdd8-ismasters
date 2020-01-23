package com.isa.scheduler;


import com.isa.service.EventService;
import org.hibernate.usertype.UserCollectionType;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

@Startup
@Singleton
public class EventScheduler {

@Inject
    EventService eventService;

    private static final Logger logger = Logger.getLogger(UserCollectionType.class.getName());

    @Schedule(hour="*",minute="0/1",second="0/60",info="every minute")

    public void availableEvents(){
        logger.info("Available events" + eventService.findAll().size());    }

}
