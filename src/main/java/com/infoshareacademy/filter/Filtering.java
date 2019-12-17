package com.infoshareacademy.filter;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.repository.FilterRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Filtering {
    List<Event> resultList = new ArrayList<>();

    public Set<String> getAllOrganizers() {
        Set<String> allOrganizers = new HashSet<>();
        for (Event event : EventsRepository.getInstance().getEvents()) {
            allOrganizers.add(event.getOrganizer().getDesignation());
        }
        return allOrganizers;
    }

    public List<Event> giveFilteredEvents(String start, String end, List<String> allOrganizers) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        List<Event> eventList = new FilterRepository().allEvents();
        List<Event> resultList2 = new ArrayList<>();
        resultList.addAll(eventList.stream()
                .filter(event -> LocalDate.parse(event.getStartDate().substring(0, 10)).isAfter(startDate) && LocalDate.parse(event.getStartDate().substring(0, 10)).isBefore(endDate))
                .collect(Collectors.toList()));

        for (String organizer : allOrganizers) {
            resultList2.addAll(filterAllOrganisersOnResultList(organizer));
        }

        List<Event> sortedList;
        sortedList = resultList2.stream().sorted(Comparator.comparing((a) -> a.getOrganizer().getDesignation())).collect(Collectors.toList());
        return sortedList;

    }

    public List<Event> filterAllOrganisersOnResultList(String organizer) {
        List<Event> filteredOutPutList = new ArrayList<>();

        for (Event event : resultList) {
            if (event.getOrganizer().toString().toLowerCase().contains(organizer.toLowerCase())) {
                filteredOutPutList.add(event);
            }
        }
        return filteredOutPutList;
    }
}