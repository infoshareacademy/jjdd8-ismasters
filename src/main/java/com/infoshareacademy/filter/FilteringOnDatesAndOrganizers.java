package com.infoshareacademy.filter;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.repository.FilterRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class FilteringOnDatesAndOrganizers {
    List<Event> resultList = new ArrayList<>();
    public final static int START_DATE_SUBSTRING = 0;
    public final static int END_DATE_SUBSTRING = 10;
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
        List<Event> resultListAfterOrganizerFilter = new ArrayList<>();
        resultList.addAll(eventList.stream()
                .filter(event -> filterOnDates(event,startDate,endDate))
                .collect(Collectors.toList()));

        for (String organizer : allOrganizers) {
            resultListAfterOrganizerFilter.addAll(filterAllOrganisersOnResultList(organizer));
        }

        List<Event> sortedList;
        sortedList = resultListAfterOrganizerFilter.stream()
                .sorted(Comparator.comparing((a) -> a.getOrganizer().getDesignation()))
                .collect(Collectors.toList());
        return sortedList;

    }

    public List<Event> filterAllOrganisersOnResultList(String organizer) {
        List<Event> filteredOutputList = new ArrayList<>();

        for (Event event : resultList) {
            if (event.getOrganizer().getDesignation().toLowerCase().contains(organizer.toLowerCase())) {
                filteredOutputList.add(event);
            }
        }
        return filteredOutputList;
    }
    public boolean filterOnDates(Event event,LocalDate startDate, LocalDate endDate){
        return LocalDate.parse(event.getStartDate().substring(START_DATE_SUBSTRING, END_DATE_SUBSTRING)).isAfter(startDate.minusDays(1))
                && LocalDate.parse(event.getStartDate().substring(START_DATE_SUBSTRING, END_DATE_SUBSTRING)).isBefore(endDate.plusDays(1));

    }
}