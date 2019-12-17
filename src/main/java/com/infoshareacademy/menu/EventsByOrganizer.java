package com.infoshareacademy.menu;

import com.infoshareacademy.filter.Filtering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EventsByOrganizer {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static List<String> listOfSelectedOrganizers = new ArrayList<>();
    static String start;
    static String end;
    int menuExitCode = 0;
    static String searchString;

    public static void showAllOrganizers() {

        collectingListOfOrganizers();
        collectingStartDate();
        collectingEndDate();

        if (new Filtering().giveFilteredEvents(start, end, listOfSelectedOrganizers).isEmpty()) {
            stdout.info("Lista pusta" + "\n");
        } else {
            stdout.info("Lista wszystkich wydarzeń pofiltrowanych dla podanych warunków" + "\n");
            EventsPrinter.printEvents(new Filtering().giveFilteredEvents(start, end, listOfSelectedOrganizers));
        }

    }

    public static void printOrganizers() {
        for (String organizer : new Filtering().getAllOrganizers()) {
            stdout.info("-> " + organizer + "\n");
        }
    }

    public static List<String> filterAllOrganisers(String organizer) {

        for (String organizers : new Filtering().getAllOrganizers()) {
            if (organizers.toLowerCase().contains(organizer.toLowerCase())) {
                listOfSelectedOrganizers.add(organizers);
            }
        }
        return listOfSelectedOrganizers;
    }

    public static boolean isDateValid(String searchString) {
        return Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", searchString);
    }

    public static List<String> collectingListOfOrganizers() {
        String out = "F";
        do {
            stdout.info("Podaj nazwę organizatora lub organizatorów do filtrowania wydarzeń" + "\n");
            stdout.info("Lista Organizatorów" + "\n");
            printOrganizers();

            stdout.info("\n" + "Wybierz Organizatora" + "\n");
            searchString = Menu.scanner.nextLine();
            if (searchString.length() < 3) {
                stdout.info("Wpisz co najmniej 3 znaki\n");
            }
            filterAllOrganisers(searchString);
            stdout.info("Lista wybranych organizatorów" + "\n");
            listOfSelectedOrganizers.stream().forEach(s -> stdout.info(" " + s + "\n"));
            stdout.info("\n" + "By zakończyć dodawanie organizatorów wybierz Q lub wprowadz kolejne F" + "\n");
            out = Menu.scanner.next();
        } while (Menu.scanner.hasNextLine() && (out.equals("F")));
        return listOfSelectedOrganizers;
    }

    public static String collectingStartDate() {
        do {
            stdout.info("Podaj  Start datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
            searchString = Menu.scanner.next();
            if (!isDateValid(searchString)) {
                stdout.info("\nZły format daty!\n\n");
            }
            start = searchString;
        } while (!isDateValid(searchString));
        return start;
    }

    public static String collectingEndDate() {
        do {
            stdout.info("Podaj  koniec datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
            searchString = Menu.scanner.next();
            if (!isDateValid(searchString)) {
                stdout.info("\nZły format daty!\n\n");
            }
            end = searchString;
        } while (!isDateValid(searchString));
        return end;
    }
}