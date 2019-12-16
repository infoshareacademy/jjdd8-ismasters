package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EventSearch {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


    Scanner scanner = new Scanner(System.in);

    public void searchEvents(FilterRepository filterRepository, Predicate<Event> searchCondition) {
        EventsPrinter.printEvents(filterRepository.genericFilter(searchCondition));
    }

    public void startSearch() {

        int returnCheckInt = 0;
        String searchString;
        Predicate<Event> searchCondition;

        while (returnCheckInt != 9) {

            stdout.info("\n");
            new HeaderPrinter().printBiggerHeader();
            stdout.info("│   1. Wyszukiwanie wg miejsca eventu                              │\n");
            stdout.info("│   2. Wyszukiwanie wg organizatora                                │\n");
            stdout.info("│   3. Wyszukiwanie wg daty                                        │\n");
            stdout.info("│                                                                  │\n");
            stdout.info("│  " + ColorHandler.CYAN + " 9. Wróć                                                    " + ColorHandler.DEFAULT + "    │\n");
            stdout.info("│                                                                  │\n");
            stdout.info("└──────────────────────────────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę: \n");


            switch (ChoiceGetter.getChoice()) {
                case 1:
                    do {
                        stdout.info("Podaj miejsce do wyszukania i wciśnij ENTER\n");
                        searchString = scanner.nextLine();
                        if (searchString.length() < 3) {
                            stdout.info("Wpisz co najmniej 3 znaki\n");
                        }
                    } while (searchString.length() < 3);

                    stdout.info("Szukam: " + searchString + "\n");
                    String finalSearchString = searchString;
                    searchCondition = event -> event.getPlace().getName().toLowerCase().contains(finalSearchString.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 2:
                    do {
                        stdout.info("Podaj nazwę organizatora do wyszukania i wciśnij ENTER\n");
                        searchString = scanner.nextLine();
                        if (searchString.length() < 3) {
                            stdout.info("Wpisz co najmniej 3 znaki\n");
                        }
                    } while (searchString.length() < 3);

                    stdout.info("Szukam: " + searchString + "\n");
                    String finalSearchString1 = searchString;
                    searchCondition = event -> event.getOrganizer().getDesignation().toLowerCase().contains(finalSearchString1.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 3:
                    stdout.info("Podaj datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
                    searchString = scanner.nextLine();
                    if (!isDateValid(searchString)) {
                        stdout.info("Zły format daty\n");
                        break;
                    }
                    if (LocalDate.parse(searchString).isBefore(LocalDate.now())) {
                        stdout.info("Wybierz dzień dzisiejszy lub późniejszą datę!\n");
                        break;
                    }
                    stdout.info("Szukam: " + searchString + "\n");
                    String finalSearchString2 = searchString;
                    searchCondition = event -> event.getStartDate().contains(finalSearchString2.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 9:
                    stdout.info("Koniec wyszukiwania\n");
                    returnCheckInt = 9;
                    break;
            }
        }
    }

    public boolean isDateValid(String searchString) {
        return Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", searchString);
    }
}
