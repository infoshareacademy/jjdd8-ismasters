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
        dto.setId(4);
        dto.setName("wydarzenie nazwa");
        dto.setStartDate("24-02-1996");
        dto.setEndDate("25-02-1996");
        dto.setOrganizer("organizator");
        dto.setDescLong("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed finibus suscipit scelerisque. Morbi auctor tellus a dolor fermentum, porta pellentesque tellus viverra. Aliquam consequat nisi ut porttitor vehicula. Morbi luctus tempor tortor, eu euismod lorem mollis eu. Nunc at libero ex. Sed lobortis urna odio, in lacinia nisl aliquet sed. Duis semper iaculis orci, eget pulvinar erat convallis ut. Pellentesque finibus nibh augue, sed pulvinar libero scelerisque eu. Quisque at leo consectetur, tincidunt nulla eget, pharetra risus. Quisque hendrerit at ex eu bibendum. Morbi dignissim orci id elit viverra pellentesque. Nulla vitae leo orci.");
        return dto;
    }

}