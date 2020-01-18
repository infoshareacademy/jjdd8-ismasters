package com.isa.mapper;

import com.isa.domain.dto.OrganizerDto;
import com.isa.domain.entity.Organizer;
import com.isa.domain.api.OrganizerExternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class OrganizerMapper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public Organizer mapApiViewToEntity(OrganizerExternal organizerExternal) {
        logger.info("Organizer mapping to Entity");

        Organizer organizer = new Organizer();

        organizer.setApiId(organizerExternal.getId());
        organizer.setDesignation(organizerExternal.getDesignation());

        logger.info("Organizer mapping to Entity-> all parameters set");

        return organizer;
    }

    public OrganizerDto mapApiViewToDto(Organizer organizer) {
        logger.info("Organizer mapping to DTO");

        OrganizerDto organizerDto = new OrganizerDto();

        organizerDto.setIdDb(organizer.getId());
        organizerDto.setDesignation(organizer.getDesignation());

        logger.info("Organizer mapping to DTO-> all parameters set");

        return organizerDto;
    }
}
