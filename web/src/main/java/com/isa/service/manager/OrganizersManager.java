package com.isa.service.manager;

import com.isa.dao.OrganizersDao;
import com.isa.domain.api.OrganizerExternal;
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
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private OrganizerMapper organizerMapper;

    @Inject
    private OrganizersDao organizersDao;

    @Inject
    private ApiDataParser apiDataParser;

    public void setRelations(String filename)  {

        List<OrganizerExternal> list = null;
        try {
            list = apiDataParser.parse(filename, OrganizerExternal.class);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        logger.info("Zaimportowano listę organizatorów");

        list.stream()
                .map(o->organizerMapper.mapApiViewToEntity(o))
                .forEach(o ->{
                    organizersDao.addNewOrganizer(o);
                    logger.debug("Organizer {}",o.getId() );
                });

        logger.info("Organizatorzy zmapowani i zaimportowani do bazy");
    }

    public void setRelationsFromFile(String filename)  {

        List<OrganizerExternal> list = null;
        try {
            list = apiDataParser.parseFromFile(filename, OrganizerExternal.class);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        logger.info("Zaimportowano listę organizatorów");

        list.stream()
                .map(organizerMapper::mapApiViewToEntity)
                .forEach(o ->{
                    logger.info("Organizer Api ID: {}", o.getApiId());
                    logger.info("Organizer from DB Api ID: {}", organizersDao.findByApiId(o.getApiId()).getApiId());
                    if (!o.getApiId().equals(organizersDao.findByApiId(o.getApiId()).getApiId())) {
                        organizersDao.addNewOrganizer(o);
                        logger.info("OK ADDING");
                        logger.info("Organizer {}",o.getApiId() );
                    } else {
                        logger.info("Organizer already exists {}", o.getDesignation());
                    }
                });

        logger.info("Organizatorzy zmapowani i zaimportowani do bazy");
    }
}
