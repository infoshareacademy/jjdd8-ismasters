package com.infoshareacademy.repository;

import com.infoshareacademy.parser.Event;

import java.util.ArrayList;
import java.util.List;

public class EventsRepository {
    public static List<Event> events = new ArrayList<>();


    private EventsRepository() {
    }

    public static List<Event> getEvents() {
        return events;
    }

}
