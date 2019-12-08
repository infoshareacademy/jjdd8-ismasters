package com.infoshareacademy.repository;

import com.infoshareacademy.domain.parser.Event;

import java.util.ArrayList;
import java.util.List;

public class FilterRepository {
    List<Event> filteredOutPutList = new ArrayList<>();

    public List<Event> allEvents() {
        filteredOutPutList.addAll(EventsRepository.getEvents());
        return filteredOutPutList;
    }

    public List<Event> filterAllDatesEvents(String inputDate) {

        for (Event event : EventsRepository.getEvents()) {
            if (event.getStartDate().contains(inputDate)) {
                filteredOutPutList.add(event);
            }
        }
        return filteredOutPutList;
    }

    public List<Event> filterAllOrganisers(String organizer) {

        for (Event event : EventsRepository.getEvents()) {
            if (event.getOrganizer().toString().toLowerCase().contains(organizer.toLowerCase())) {
                filteredOutPutList.add(event);
            }
        }
        return filteredOutPutList;
    }
}

