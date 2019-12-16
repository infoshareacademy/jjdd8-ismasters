package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EventSearch {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static String SEARCH_MENU_OPTION1 = "1. Wyszukaj wydarzenia wg miejsca";
    final static String SEARCH_MENU_OPTION2 = "2. Wyszukaj wydarzenia wg organizatora";
    final static String SEARCH_MENU_OPTION3 = "3. Wyszukaj wydarzenia wg daty";
    final static String SEARCH_MENU_EXIT = "Wybierz 9, aby wrócić do poprzedniego menu";

    public void searchEvents(FilterRepository filterRepository, Predicate<Event> searchCondition) {
        EventsPrinter.printingEvents(filterRepository.genericFilter(searchCondition));
    }

    public void startSearch() {

        int returnCheckInt = 0;
        String searchString;
        Predicate<Event> searchCondition;
        ScreenCleaner.cleaningConsoleWindow();
        boolean isDateToEarly = true;

        while (returnCheckInt != 9) {

            MenuBuilder.generalEventSearchPrinting();

            switch (ChoiceGetter.getChoice()) {
                case 1:
                    do {
                        stdout.info("Podaj miejsce do wyszukania i wciśnij ENTER\n");
                        searchString = Menu.scanner.next();
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
                        searchString = Menu.scanner.next();
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
                    do {
                        do {
                            stdout.info("Podaj datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
                            searchString = Menu.scanner.next();
                            if (!isDateValid(searchString)) {
                                stdout.info("\nZły format daty!\n\n");
                            }
                        }
                        while (!isDateValid(searchString));


                        if (LocalDate.parse(searchString).isBefore(LocalDate.now())) {
//                            isDateToEarly = true;
                            stdout.info("\nWybierz dzień dzisiejszy lub późniejszą datę!\n\n");
//                            break;
                        } else {
                            isDateToEarly = false;
                        }

                    } while (isDateToEarly);

                    stdout.info("Szukam: " + searchString + "\n");
                    String finalSearchString2 = searchString;
                    searchCondition = event -> event.getStartDate().contains(finalSearchString2.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 9:
                    stdout.info("Koniec wyszukiwania\n");
                    returnCheckInt = 9;
                    break;

                default:
                    MenuBuilder.nothingHereYetPromptPrinting();
            }
        }
    }

    public boolean isDateValid(String searchString) {
        return Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", searchString);
    }
}
