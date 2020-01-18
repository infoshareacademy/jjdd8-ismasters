package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.domain.dto.EventDto;
import com.isa.mapper.EventMapper;
import com.isa.service.manager.EventManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class EventService {


    @Inject
    private EventManager eventManager;

    @Inject
    private EventMapper eventMapper;

    @Inject
    private EventDao eventDao;


    public List<EventDto> findAll(){

        List<EventDto> eventDtoList = new ArrayList<>();

        eventDao.findAll().stream()
                .forEach(event -> eventDtoList.add(eventMapper.mapApiViewToDto(event)));

        return eventDtoList;
    }

}
