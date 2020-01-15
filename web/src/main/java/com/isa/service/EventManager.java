package com.isa.service;

import com.isa.domain.entity.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventManager {

    @Inject
    private EventManager eventManager;

    @Inject
    private User user;

    @Inject
    private TicketType ticketType;

    @Inject
    private Organizer organizer;

    @Inject
    private Place place;

    @Inject
    private Url url;


}
