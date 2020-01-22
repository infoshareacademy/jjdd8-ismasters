package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.domain.dto.EventDto;
import com.isa.mapper.EventMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import com.isa.domain.entity.Event;

import java.util.stream.Collectors;

@Stateless
public class EventService {


    @Inject
    private com.isa.service.service.domain.EventService eventService;

    @Inject
    private EventMapper eventMapper;

    @Inject
    private EventDao eventDao;


    public List<EventDto> findAll() {

        List<EventDto> eventDtoList = new ArrayList<>();

        eventDao.findAll()
                .forEach(event -> eventDtoList.add(eventService.convertToLongDto(event)));

        return eventDtoList;
    }

    public EventDto findById(Long id) {
        Event event = eventDao.findById(id).orElseThrow();
        return eventService.convertToLongDto(event);
    }

    public List<EventDto> searchEvents(String search) {
        return eventDao.searchEvents(search).stream()
                .map((event -> eventMapper.mapEntityToDto(event)))
                .collect(Collectors.toList());
    }
}