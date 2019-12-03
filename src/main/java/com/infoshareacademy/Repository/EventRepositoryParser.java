package com.infoshareacademy.Repository;

import java.util.ArrayList;

public class EventRepositoryParser {
    private static EventRepositoryParser eventRepositoryParser;
    private ArrayList<> events = new ArrayList<>();

    private EventRepositoryParser() {

    }

    public static EventRepositoryParser getInstance() {
        if (eventRepositoryParser == null) {
            eventRepositoryParser = new EventRepositoryParser();
        }
        return eventRepositoryParser;
    }

    public void searchEvent() {

    }

    public void searchDate() {

    }

    public void searchOrganizer() {

    }
}
