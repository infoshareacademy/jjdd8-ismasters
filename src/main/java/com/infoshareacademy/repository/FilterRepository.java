package com.infoshareacademy.repository;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.service.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class FilterRepository {
    Parser parser = new Parser();
    List<Event> outPutList = new ArrayList<>();

    public void allEvents() {
        parser.parseData();
        for (int i = 0; i < 10; i++) {
            System.out.println(EventsRepository.getEvents().get(i));
        }
    }

    public List<Event> filterAllDatesEvents(String date) {
        parser.parseData();
        for (Event event : EventsRepository.getEvents()) {
            if (event.getEndDate().equals(date)) {
                outPutList.add(event);
            }
        }
        return outPutList;
    }

    public List<Event> filterAllOrganisers(String organizer) {
        parser.parseData();
        for (Event event : EventsRepository.getEvents()) {
            if (event.getOrganizer().equals(organizer)) {
                outPutList.add(event);
            }
        }
        return outPutList;
    }


    public static void main(String[] args) {
        FilterRepository f1 = new FilterRepository();


    }
}

