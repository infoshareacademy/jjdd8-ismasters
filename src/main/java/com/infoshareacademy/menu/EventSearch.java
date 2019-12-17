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

    static final String SEARCH_MENU_OPTION1 = "1. Wyszukaj wydarzenia wg miejsca";
    static final String SEARCH_MENU_OPTION2 = "2. Wyszukaj wydarzenia wg organizatora";
    static final String SEARCH_MENU_OPTION3 = "3. Wyszukaj wydarzenia wg daty";
    static final String SEARCH_MENU_EXIT = "Wybierz 9, aby wrócić do poprzedniego menu";

    public void searchEvents(FilterRepository filterRepository, Predicate<Event> searchCondition) {
        EventsPrinter.printEvents(filterRepository.filterWithLambdaPassedIn(searchCondition));
    }

    public void showSearchResults() {

        int menuExitCode = 0;
        String searchString;
        Predicate<Event> searchCondition;
        ScreenCleaner.cleanConsoleWindow();
        boolean isDateToEarly = true;

        while (menuExitCode != 9) {

            MenuBuilder.printGeneralEventSearch();

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
                    String effectiveFinalSearchByPlace = searchString;
                    searchCondition = event -> event.getPlace().getName().toLowerCase().replaceAll("\\s","").contains(effectiveFinalSearchByPlace.toLowerCase().replaceAll("\\s",""));
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
                    String effectiveFinalSearchByOrganizer = searchString;
                    searchCondition = event -> event.getOrganizer().getDesignation().toLowerCase().contains(effectiveFinalSearchByOrganizer.toLowerCase());
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
                            stdout.info("\nWybierz dzień dzisiejszy lub późniejszą datę!\n\n");
                        } else {
                            isDateToEarly = false;
                        }
                    } while (isDateToEarly);

                    stdout.info("Szukam: " + searchString + "\n");
                    String effectiveFinalSearchByDate = searchString;
                    searchCondition = event -> event.getStartDate().contains(effectiveFinalSearchByDate.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 9:
                    stdout.info("Koniec wyszukiwania\n");
                    menuExitCode = 9;
                    break;

                default:
                    MenuBuilder.printNumberInactiveInfo();
            }
        }
    }

    public boolean isDateValid(String searchString) {
        return Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", searchString);
    }
}