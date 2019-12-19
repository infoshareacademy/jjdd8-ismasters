package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.infoshareacademy.menu.EventsPrinter.printEvents;

public class Menu extends MenuBuilder {

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    static final String MAIN_MENU_OPTION1 = "1. Pokaż wszystkie wydarzenia";
    static final String MAIN_MENU_OPTION2 = "2. Pokaż najbliższe wydarzenia";
    static final String MAIN_MENU_OPTION3 = "3. Pokaż wydarzenie wyszukanych organizatorów oraz dat";
    static final String MAIN_MENU_OPTION4 = "4. Wyszukaj wydarzenie";
    static final String MAIN_MENU_EXIT = "Wpisane 9 powoduje wyjscie z programu";

    public static void mainMenu() {
        FilterRepository filterRepository = new FilterRepository();

        int mainExitCode = 0;
        ScreenCleaner.cleanConsoleWindow();
        MenuBuilder.printGreeting();

        while (mainExitCode != 9) {
            MenuBuilder.printMenuBuilder();

            switch (ChoiceGetter.getChoice()) {
                case 1:
                    printEvents(filterRepository.allEvents());
                    stdout.info("\n");
                    break;
                case 2:
                    ScreenCleaner.cleanConsoleWindow();
                    new NearestEvents().showNearestEvents();
                    break;
                case 3:
                    ScreenCleaner.cleanConsoleWindow();
                    EventsByOrganizer.showAllOrganizers();
                    break;
                case 4:
                    ScreenCleaner.cleanConsoleWindow();
                    new EventSearch().showSearchResults();
                    break;
                case 9:
                    MenuBuilder.printGoodByeWindow();
                    mainExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    MenuBuilder.printNumberInactiveInfo();
            }
        }
    }
}