package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.filter.FilteringOnDatesAndOrganizers;
import com.infoshareacademy.menu.util.DateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class EventsByOrganizer {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static List<String> listOfSelectedOrganizers = new ArrayList<>();
    static String start;
    static String end;
    static String searchString;

    DateValidator dateValidator = new DateValidator();

    public  void showAllOrganizers() {
        List<Event> listOfFilteredEventsOnOrganizersAndDates = new ArrayList<>();

        collectsListOfOrganizers();
        collectStartDate();
        collectsEndDate();

        if (new FilteringOnDatesAndOrganizers().giveFilteredEvents(start, end, listOfSelectedOrganizers).isEmpty()) {
            stdout.info("Lista pusta" + "\n");
        } else {
            stdout.info("\n" + "Lista wszystkich wydarzeń pofiltrowanych dla podanych warunków" + "\n");
            listOfFilteredEventsOnOrganizersAndDates.addAll(new FilteringOnDatesAndOrganizers().giveFilteredEvents(start, end, listOfSelectedOrganizers));
            EventsPrinter.printEvents(listOfFilteredEventsOnOrganizersAndDates);
            listOfSelectedOrganizers.clear();
        }
    }

    public  void printOrganizers() {
        new FilteringOnDatesAndOrganizers().getAllOrganizers().stream().forEach(s -> stdout.info(" " + s + "\n"));
    }

    public  List<String> filterAllOrganisers(String organizer) {

        listOfSelectedOrganizers = new FilteringOnDatesAndOrganizers().getAllOrganizers()
                .stream().filter(o->o.toLowerCase().contains(organizer.toLowerCase()))
                .collect(Collectors.toList());

        return listOfSelectedOrganizers;
    }


    public  List<String> collectsListOfOrganizers() {
        String out = "F";
        do {
            stdout.info("Podaj nazwę organizatora lub organizatorów do filtrowania wydarzeń" + "\n");
            stdout.info("Lista Organizatorów" + "\n");
            printOrganizers();
            chooseOrganizer();
            filterAllOrganisers(searchString);
            stdout.info("Lista wybranych organizatorów" + "\n");
            listOfSelectedOrganizers.stream().forEach(s -> stdout.info(" " + s + "\n"));
            stdout.info("\n" + "By zakończyć dodawanie organizatorów wybierz Q lub wprowadz kolejnych wybierz F" + "\n");
            out = Menu.scanner.nextLine();
        } while ((out.equals("F")));
        return listOfSelectedOrganizers;
    }

    public  String collectStartDate() {
        do {
            stdout.info("Podaj datę początku wyszukania w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
            searchString = Menu.scanner.nextLine();
            if (!dateValidator.isDateValid(searchString)) {
                stdout.info("\nZły format daty!\n\n");
            }
            start = searchString;
        } while (!dateValidator.isDateValid(searchString));
        return start;
    }

    public  String collectsEndDate() {
        do {
            stdout.info("Podaj  datę końca szukania w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
            searchString = Menu.scanner.nextLine();
            if (!dateValidator.isDateValid(searchString)) {
                stdout.info("\nZły format daty!\n\n");
            }
            end = searchString;
        } while (!dateValidator.isDateValid(searchString));
        return end;
    }

    public  String chooseOrganizer() {
        do {
            stdout.info("\n" + "Wybierz Organizatora" + "\n");
            stdout.info("Wpisz co najmniej 3 znaki\n");
            Menu.scanner.nextLine();
            searchString = Menu.scanner.nextLine();
        } while ((searchString.length() < 3));
        return searchString;
    }
}