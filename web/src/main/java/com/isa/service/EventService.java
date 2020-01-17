package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.mock.EventDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventService {

    @Inject
    EventDao eventDao;

    public EventDTO getSingleEvent(){

        //FIXME
        EventDTO dto = new EventDTO();
        dto.setName("wydarzxenieadasfas f");
        return dto;
    }

}