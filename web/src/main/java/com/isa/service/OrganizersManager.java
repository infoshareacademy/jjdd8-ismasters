package com.isa.service;

import com.isa.dao.EventDao;
import com.isa.dao.OrganizersDao;
import com.isa.dao.PlaceDao;
import com.isa.dao.UrlDao;
import com.isa.domain.entity.Organizer;
import com.isa.domain.entity.TicketType;
import com.isa.domain.entity.User;
import com.isa.mapper.EventMapper;
import com.isa.parser.ApiDataParser;

import javax.inject.Inject;

public class OrganizersManager {
    @Inject
    private EventMapper eventMapper;

    @Inject
    private EventDao eventDao;

    @Inject
    private User user;

    @Inject
    private TicketType ticketType;

    @Inject
    private Organizer organizer;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private UrlDao urlDao;

    @Inject
    private OrganizersDao organizersDao;

    @Inject
    private ApiDataParser apiDataParser;
}
