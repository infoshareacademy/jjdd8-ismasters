package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.filter.FilteringOnDatesAndOrganizers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EventsByOrganizer {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static List<String> listOfSelectedOrganizers = new ArrayList<>();
    static String start;
    static String end;
    static String searchString;

    public static void showAllOrganizers() {
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

    public static void printOrganizers() {
        new FilteringOnDatesAndOrganizers().getAllOrganizers().stream().forEach(s -> stdout.info(" " + s + "\n"));
    }

    public static List<String> filterAllOrganisers(String organizer) {

        listOfSelectedOrganizers = new FilteringOnDatesAndOrganizers().getAllOrganizers()
                .stream().filter(o->o.toLowerCase().contains(organizer.toLowerCase()))
                .collect(Collectors.toList());

        return listOfSelectedOrganizers;
    }

    public static boolean isDateValid(String searchString) {
        return Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", searchString);
    }

    public static List<String> collectsListOfOrganizers() {
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

    public static String collectStartDate() {
        do {
            stdout.info("Podaj  Start datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
            searchString = Menu.scanner.nextLine();
            if (!isDateValid(searchString)) {
                stdout.info("\nZły format daty!\n\n");
            }
            start = searchString;
        } while (!isDateValid(searchString));
        return start;
    }

    public static String collectsEndDate() {
        do {
            stdout.info("Podaj  koniec datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
            searchString = Menu.scanner.nextLine();
            if (!isDateValid(searchString)) {
                stdout.info("\nZły format daty!\n\n");
            }
            end = searchString;
        } while (!isDateValid(searchString));
        return end;
    }

    public static String chooseOrganizer() {
        do {
            stdout.info("\n" + "Wybierz Organizatora" + "\n");
            stdout.info("Wpisz co najmniej 3 znaki\n");
            Menu.scanner.nextLine();
            searchString = Menu.scanner.nextLine();
        } while ((searchString.length() < 3));
        return searchString;
    }
}