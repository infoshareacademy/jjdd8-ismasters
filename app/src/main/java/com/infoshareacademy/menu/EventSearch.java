package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.menu.util.DateValidator;
import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.function.Predicate;

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
        DateValidator dateValidator = new DateValidator();


        while (menuExitCode != 9) {

            if (!Menu.BREADCRUMBSTACK.peek().equals("Wyszukiwanie wydarzeń")) {
                Menu.BREADCRUMBSTACK.add("Wyszukiwanie wydarzeń");
            }
            BreadcrumbsPrinter.printBreadcrumbs();

            MenuBuilder.printGeneralEventSearch();
            boolean isDateToEarly = true;

            switch (ChoiceGetter.getChoice()) {
                case 1:
                    do {
                        stdout.info("Podaj miejsce do wyszukania i wciśnij ENTER\n");
                        Menu.scanner.nextLine();
                        searchString = Menu.scanner.nextLine().replaceAll("\\s+", "");
                        if (searchString.length() < 3) {
                            stdout.info("Wpisz co najmniej 3 znaki\n");
                        }
                    } while (searchString.length() < 3);

                    stdout.info("Szukam: " + searchString + "\n\n");
                    String effectiveFinalSearchByPlace = searchString;
                    searchCondition = event -> event.getPlace().getName().toLowerCase().contains(effectiveFinalSearchByPlace.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 2:
                    do {
                        stdout.info("Podaj nazwę organizatora do wyszukania i wciśnij ENTER\n");
                        Menu.scanner.nextLine();
                        searchString = Menu.scanner.nextLine();
                        if (searchString.length() < 3) {
                            stdout.info("Wpisz co najmniej 3 znaki\n");
                        }
                    } while (searchString.length() < 3);

                    stdout.info("Szukam: " + searchString + "\n\n");
                    String effectiveFinalSearchByOrganizer = searchString;
                    searchCondition = event -> event.getOrganizer().getDesignation()
                            .toLowerCase().contains(effectiveFinalSearchByOrganizer.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 3:
                    LocalDate searchDate;
                    do {
                        do {
                            stdout.info("Podaj datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
                            Menu.scanner.nextLine();
                            searchString = Menu.scanner.next();
                            if (!dateValidator.isDateValid(searchString)) {
                                stdout.info("\nZły format daty!\n\n");
                            }
                        }
                        while (!dateValidator.isDateValid(searchString));
                        searchDate = LocalDate.parse(searchString, DateTimeFormatter.ofPattern("yyyy-MM-dd").withResolverStyle(ResolverStyle.SMART));
                        if (searchDate.isBefore(LocalDate.now())) {
                            stdout.info("\nWybierz dzień dzisiejszy lub późniejszą datę!\n\n");
                        } else {
                            isDateToEarly = false;
                        }
                    } while (isDateToEarly);

                    stdout.info("Szukam: " + searchDate.toString() + "\n\n");
                    String effectiveFinalSearchByDate = searchString;
                    searchCondition = event -> event.getStartDate().contains(effectiveFinalSearchByDate);
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 9:
                    Menu.BREADCRUMBSTACK.pop();
                    menuExitCode = 9;
                    break;

                default:
                    MenuBuilder.printNumberInactiveInfo();
            }
        }
    }
}