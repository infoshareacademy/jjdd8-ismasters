package com.infoshareacademy.repository;


import com.infoshareacademy.domain.parser.Event;

import java.util.ArrayList;
import java.util.List;

public class EventsRepository {
    private static List<Event> events = new ArrayList<>();
    private static EventsRepository eventsRepository;


    private EventsRepository() {

    }

    public static EventsRepository getInstance() {
        if (eventsRepository == null) {
            eventsRepository = new EventsRepository();
        }
        return eventsRepository;
    }

    public List<Event> getEvents() {
        return events;
    }

}
