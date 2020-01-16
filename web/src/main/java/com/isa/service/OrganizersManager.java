package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.dao.OrganizersDao;
import com.isa.dao.PlaceDao;
import com.isa.dao.UrlDao;
import com.isa.domain.api.EventApi;
import com.isa.domain.api.OrganizerApi;
import com.isa.domain.entity.Event;
import com.isa.domain.entity.Organizer;
import com.isa.domain.entity.TicketType;
import com.isa.domain.entity.User;
import com.isa.mapper.EventMapper;
import com.isa.mapper.OrganizerMapper;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@ApplicationScoped
public class OrganizersManager {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private OrganizerMapper organizerMapper;

    @Inject
    private OrganizersDao organizersDao;

    @Inject
    private ApiDataParser apiDataParser;

    public void setRelations(String filename) throws IOException {
        List<OrganizerApi> list = apiDataParser.parse(filename, OrganizerApi.class);
        logger.info("Zaimportowano listę organizatorów");
        for (OrganizerApi o: list) {
            Organizer organizer= new Organizer();
            organizer = organizerMapper.mapApiViewToEntity(o);

            logger.info("Organizatorzy mapowane i kierowane do bazy danych");
            organizersDao.addNewOrganizer(organizer);
        }
    }
}
