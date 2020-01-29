package com.isa.service.domain;

import com.isa.dao.OrganizersDao;
import com.isa.domain.api.OrganizerApi;
import com.isa.domain.dto.OrganizerDto;
import com.isa.mapper.OrganizerMapper;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OrganizersService {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private OrganizerMapper organizerMapper;

    @Inject
    private OrganizersDao organizersDao;

    @Inject
    private ApiDataParser apiDataParser;

    public void setRelations(String filename) throws IOException {

        List<OrganizerApi> list = apiDataParser.parse(filename, OrganizerApi.class);

        logger.debug("Zaimportowano listę organizatorów");

        list.stream()
                .map(o->organizerMapper.mapApiToEntity(o))
                .forEach(o ->{
                    organizersDao.addNewOrganizer(o);
                    logger.debug("Organizer {}",o.getId() );
                });

        logger.debug("Organizatorzy zmapowani i zaimportowani do bazy");
    }

    public List<OrganizerDto> findAll(){
        List<OrganizerDto> organizerDtoList = new ArrayList<>();

        organizersDao.findAll().forEach(
                o-> organizerDtoList.add(organizerMapper.mapEnityToDto(o))
        );
        return organizerDtoList;
    }
}
