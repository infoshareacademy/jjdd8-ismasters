package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.mock.EventDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class EventService {

//    public Map<String, Object> toSingleEvent() {
//        Map <String, Object> model = new HashMap<>();
//        List<EventDTO> events = new ArrayList<>();
//        EventDTO singleEvent = events.get(0);
//        EventDTO eventDTO = eventsListToDTO(singleEvent);
//        model.put("event", eventDTO);
//        return model;
//    }

//    public EventDTO eventsListToDTO(EventDTO event){
//        EventDTO DTO = new EventDTO();
//        DTO.setName(event.getName());
//        DTO.setStartDate(event.getStartDate());
//        return DTO;
//    }

    @Inject
    EventDao eventDao;

    public EventDTO getSingleEvent(){

        //FIXME
        EventDTO dto = new EventDTO();
        dto.setName("wydarzxenieadasfas f");
        return dto;
    }

}