package com.isa.mapper;

import com.isa.domain.api.OrganizerApi;
import com.isa.domain.dto.OrganizerDto;
import com.isa.domain.entity.Organizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class OrganizerMapper {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Organizer mapApiToEntity(OrganizerApi organizerApi) {
        logger.debug("Organizer mapping to Entity");

        Organizer organizer = new Organizer();

        organizer.setApiId(organizerApi.getId());
        organizer.setDesignation(organizerApi.getDesignation());

        logger.debug("Organizer mapping to Entity-> all parameters set organizer ApiId {}", organizer.getId());

        return organizer;
    }

    public OrganizerDto mapEnityToDto(Organizer organizer) {
        logger.debug("Organizer mapping to DTO");

        OrganizerDto organizerDto = new OrganizerDto();

        organizerDto.setIdDb(organizer.getId());
        organizerDto.setDesignation(organizer.getDesignation());

        logger.debug("Organizer mapping to DTO-> all parameters set organizerDto IdDb {}", organizerDto.getIdDb());

        return organizerDto;
    }
}
