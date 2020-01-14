package com.isa.mapper;

import com.isa.domain.entity.Organizer;
import com.isa.domain.api.OrganizerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class OrganizerMapper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public Organizer mapApiViewToEntity(OrganizerApi organizerApi){
        logger.info("Organizer mapping to Entity");

        Organizer organizer = new Organizer();

        organizer.setApiId(organizerApi.getId());
        organizer.setDesignation(organizerApi.getDesignation());

        // TODO Robert Dodać jeszcze obiekt klasy Address

        logger.info("Organizer mapping to Entity-> all parameters set");

        return organizer;
    }
}
