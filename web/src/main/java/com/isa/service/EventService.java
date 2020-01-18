package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.domain.entity.Event;
import com.isa.mapper.EventMapper;
import com.isa.mock.EventDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
@Stateless
public class EventService {

    @Inject
    EventDao eventDao;

    @Inject
    EventMapper eventMapper;

    public EventDTO findById(Long id) {
        Event event = eventDao.findById(id).orElseThrow();
        return eventMapper.mapEntityToDto(event);
    }
}