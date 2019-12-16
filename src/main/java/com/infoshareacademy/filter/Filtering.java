package com.infoshareacademy.filter;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.repository.FilterRepository;
import com.infoshareacademy.service.parser.Parser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Filtering {

 /*   public List<String> giveDays(String dateStart, String dateEnd) {
        List<String> seekDates = new ArrayList<>();
        LocalDate dateFirst = LocalDate.parse(dateStart);
        LocalDate dateSecond = LocalDate.parse(dateEnd);
        LocalDate count = dateFirst;
        while (!count.equals(dateSecond)) {
            seekDates.add(count.format(DateTimeFormatter.ofPattern("yyyy-MM-DD")));
            count = count.plusDays(1);
        }
        return seekDates;
    }*/
    public Set<String> getAllOrganizers(){
        Set<String> allOrganizers = new HashSet<>();
        for (Event event : EventsRepository.getEvents() ) {
            allOrganizers.add(event.getOrganizer().getDesignation());
        }
        return allOrganizers;
    }

    public List<Event> giveFilteredEvents(String start, String end, Set<String> allOrganizers) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        List<Event> resultList = new ArrayList<>();

           resultList.addAll(new FilterRepository().allEvents().stream()
                   .filter(event ->  LocalDate.parse(event.getStartDate().substring(0, 10)).isAfter(startDate) && LocalDate.parse(event.getStartDate().substring(0,10)).isBefore(endDate))
                   .collect(Collectors.toSet()));

           for (String organizer :allOrganizers) {
            resultList.addAll(new FilterRepository().filterAllOrganisers(organizer));
        }

        List<Event> sortedList;
        sortedList = resultList.stream().sorted(Comparator.comparing((a)->a.getOrganizer().getDesignation())).collect(Collectors.toList());
        return sortedList;

    }


}