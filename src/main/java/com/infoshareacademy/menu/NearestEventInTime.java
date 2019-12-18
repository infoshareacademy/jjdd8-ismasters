package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.repository.FilterRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NearestEventInTime {

    private static String substringDate;
    private static String substringTime;

    public static void main(String[] args) {
        nearestInTime();
    }

    public static void nearestInTime(){

        FilterRepository filterRepository = new FilterRepository();
        FilterRepository filterRepository1 = new FilterRepository();


        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println(formattedDateTime);

        substringDate = formattedDateTime.substring(0, 10);
        substringTime = formattedDateTime.substring(11, 16);
        System.out.println("Formatted LocalDate : " + substringDate + "\nFormatted LocalTime : " + substringTime);

        List<Event> asd = filterRepository.filterAllDatesEvents(substringDate);
        System.out.println(asd);

        List listall = List.copyOf(filterRepository.allEvents());
        String s = filterRepository.allEvents().toString();
        int contains = s.compareTo(substringDate);
//        System.out.println("filtered " + contains);
        listall.contains(substringDate);
        listall.contains(substringTime);

//        List f = new ArrayList();
//        f.addAll(listall);
//        f.stream().findFirst().toString();
//        System.out.println(f);

//        for (String substringDate : listall){
//            System.out.println(substringDate);
//        }
    }

}
