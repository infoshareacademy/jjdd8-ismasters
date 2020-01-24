package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.domain.dto.EventDto;
import com.isa.mapper.EventMapper;
import com.isa.service.manager.EventManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import com.isa.domain.entity.Event;

import java.util.stream.Collectors;

@Stateless
public class EventService {


    @Inject
    private EventManager eventManager;

    @Inject
    private EventMapper eventMapper;

    @Inject
    private EventDao eventDao;


    public List<EventDto> findAll() {

        List<EventDto> eventDtoList = new ArrayList<>();

        eventDao.findAll()
                .forEach(event -> eventDtoList.add(eventManager.setRelationsToDTO(event)));

        return eventDtoList;
    }

    public EventDto findById(Long id) {
        Event event = eventDao.findById(id).orElseThrow();
        return eventMapper.mapEntityToDto(event);
    }

    public List<EventDto> searchEvents(String search) {
        return eventDao.searchEvents(search).stream()
                .map((event -> eventMapper.mapEntityToDto(event)))
                .collect(Collectors.toList());
    }

    public EventDto userClosestFavEvent(Long id) {
        Event favEvent = eventDao.getClosestInTimeUserFav(id);
         return eventMapper.mapEntityToDto(favEvent);
    }
}