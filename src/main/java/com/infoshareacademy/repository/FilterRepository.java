package com.infoshareacademy.repository;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.service.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class FilterRepository {
    List<Event> outPutList = new ArrayList<>();

    public void allEvents() {

        for (int i = 0; i < 10; i++) {
            System.out.println(EventsRepository.getEvents().get(i));
        }
    }

    public List<Event> filterAllDatesEvents(String date) {

        for (Event event : EventsRepository.getEvents()) {
            if (event.getEndDate().equals(date)) {
                outPutList.add(event);
            }
        }
        return outPutList;
    }

    public List<Event> filterAllOrganisers(String organizer) {

        for (Event event : EventsRepository.getEvents()) {
            if (event.getOrganizer().equals(organizer)) {
                outPutList.add(event);
            }
        }
        return outPutList;
    }

}

