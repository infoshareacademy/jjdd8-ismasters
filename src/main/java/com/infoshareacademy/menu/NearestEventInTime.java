package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.repository.FilterRepository;
import com.infoshareacademy.service.parser.Parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class NearestEventInTime {

    private static String substringDate;
    private static String substringTime;
    private static String substringTime2;

    public static void main(String[] args) {
        final String JSON = "JSON_example";
        Parser parser = new Parser();
        parser.initialization(JSON);
        nearestInTime();
//    neartimeevent2();
//        neartime();
    }

    public static void searchEvents(FilterRepository filterRepository, Predicate<Event> searchCondition) {
        EventsPrinter.printEvents(filterRepository.filterWithLambdaPassedIn(searchCondition));
    }

    public static void neartime(){
        String search1;
        String search2;
        Predicate<Event> searchCondition;
        boolean isTimeEarly = true;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = currentDateTime.format(formatter);
        substringTime = formattedDateTime.substring(11, 16);
        substringDate = formattedDateTime.substring(0, 10);

        do{
            search1= substringDate;
            search2= substringTime;
            if(LocalTime.parse(search2).isBefore(LocalTime.now())){
                System.out.println("za mloda godzina");
            } else {
                isTimeEarly = false;
            }
        }
        while (isTimeEarly);

        System.out.println("szukam " + search1 + " " + search2 + "\n");
        String effect = search1;
        searchCondition = event -> event.getStartDate().contains(effect)&&event.getStartDate().contains(substringTime);
        searchEvents(new FilterRepository(), searchCondition);
    }

    public static void neartimeevent2(){
        String searchString;
        String searchString2;
        Predicate<Event> searchCondition;
        boolean isDateTooEarly = true;
        boolean isTimeTooEarly = true;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(formattedDateTime);

        substringDate = formattedDateTime.substring(0, 10);
        substringTime = formattedDateTime.substring(11, 16);
        substringTime2 = formattedDateTime.substring(11, 13);
        String dateAndTime = new StringBuilder(substringDate).append(" ").append(substringTime2).toString();
        System.out.println(dateAndTime);


        do {
            searchString = substringDate;
            searchString2 = substringTime;
            if (!isDateValid(searchString)) {
                System.out.println("nie ta data");
            }
        }
        while (!isDateValid(searchString));

        if (LocalDate.parse(searchString).isBefore(LocalDate.now())) {
            System.out.println("za wczesnie");
        } else {
            isDateTooEarly = false;
        }

        if(LocalTime.parse(searchString2).isBefore(LocalTime.now())){
            System.out.println("godzina za mloda");
        } else {
            isTimeTooEarly = false;
        }
        while (isDateTooEarly) ;

        System.out.println("szukam " + searchString + searchString2 + "\n");
        String effective = searchString + " " + searchString2;
        searchCondition = event -> event.getStartDate().contains(effective.toLowerCase());
        searchEvents(new FilterRepository(), searchCondition);

    }

    public static boolean isDateValid(String searchString) {
        return Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", searchString);
    }

    public static void nearestInTime(){

        FilterRepository filterRepository = new FilterRepository();
        EventSearch eventSearch = new EventSearch();


        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(formattedDateTime);

        substringDate = formattedDateTime.substring(0, 10);
        substringTime = formattedDateTime.substring(11, 16);
        substringTime2 = formattedDateTime.substring(11, 13);
        System.out.println("Formatted LocalDate : " + substringDate + "\nFormatted LocalTime : " + substringTime);

        List<Event> asd = filterRepository.filterAllDatesEvents(substringDate);
//        System.out.println("asd list" + asd.toString());

        String substringTime3 = substringTime2;
//        int time2 = Integer.parseInt(substringTime3);
//        int time3 = time2 + 1;

        List<Event> qwef = filterRepository.allEvents();
//        System.out.println("asfasf" + qwef);

        DateTimeFormatter formatter2 = DateTimeFormatter.ISO_DATE;
        String formattedDate = currentDateTime.format(formatter2);
        System.out.println(formattedDate);

//        List<Event> fsa = filterRepository.filterWithLambdaPassedIn(x -> LocalDate.of().isAfter(LocalDate.now()));

//        fsa.stream().filter(event -> event.getStartDate().contains(substringTime2)).findFirst().get();
//        orElse(fsa.stream().filter(event -> event.getStartDate().contains(nasfassf)));

//        System.out.println("sdasd" + fsa.toString());
//        List<Event> rtsa = filterRepository.filterWithLambdaPassedIn(event -> event.getStartDate().contains(substringDate)&&event.getStartDate().contains(substringTime));
//        System.out.println("reas" + rtsa);1

//        LocalDate date1 = LocalDate.parse("2017-06-22");
//        System.out.println("date 1 " + date1);
//        LocalDate date2 = LocalDate.parse("2017-06-22");
//        System.out.println("date 2 " + date2);
//        System.out.println("date 2comprae " + date2.compareTo(date1));

        /* Comparing the Dates with the given year, month and
         * day information. The given data is passed in the of() method
         * of LocalDate to create instances of LocalDate and then compared
         * using the compareTo() method.
         *
         */
//        LocalDate date3 = LocalDate.of(2017, 06, 22);
//        System.out.println("date 3 " + date3);
//        LocalDate date4 = LocalDate.of(2017, 10, 26);
//        System.out.println("date 4 " + date4);
//        System.out.println("date 3 4 comprae " + date4.compareTo(date3));

        /* Given Date is compared with the current Date
         */
//        LocalDate date5 = LocalDate.now();
//        System.out.println("date 5 " + date5);
//        LocalDate date6 = LocalDate.of(2016, 02, 10);
//        System.out.println("date 6 " + date6);
//        System.out.println("date 5 6 compare " + date6.compareTo(date5));

//        LocalTime time1 = LocalTime.parse("16-23");
        LocalTime time1 = LocalTime.of(16,23);
        System.out.println("time1 " + time1);
        LocalTime time2 = LocalTime.now();
        System.out.println("time2 " + time2);
        System.out.println("compare " + time2.compareTo(time1));

        Integer ss = Integer.parseInt(substringTime2);
        System.out.println("ss" + ss);

    }
}