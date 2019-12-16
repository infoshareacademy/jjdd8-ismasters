package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.infoshareacademy.menu.EventsPrinter.printingEvents;

public class Menu extends MenuBuilder {

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static String MAIN_MENU_OPTION1 = "1. Pokaż wszystkie wydarzenia";
    final static String MAIN_MENU_OPTION2 = "2. Pokaż najbliższe wydarzenia";
    final static String MAIN_MENU_OPTION3 = "3. Pokaż wydarzenie promowanych organizatorów";
    final static String MAIN_MENU_OPTION4 = "4. Wyszukaj wydarzenie";
    final static String MAIN_MENU_EXIT = "Wpisane 9 powoduje wyjscie z programu";

    public static void mainMenu() {
        FilterRepository filterRepository = new FilterRepository();

        int mainExitCode = 0;
        ScreenCleaner.cleanConsoleWindow();
        MenuBuilder.printGreeting();

        while (mainExitCode != 9) {
            MenuBuilder.menuBuilderPrinting();

            switch (ChoiceGetter.getChoice()) {
                case 1:
                    printingEvents(filterRepository.allEvents());
                    stdout.info("\n");
                    break;
                case 2:
                    ScreenCleaner.cleanConsoleWindow();
                    new NearestEvents().showNearestEvents();
                    break;
                case 3:
                    ScreenCleaner.cleanConsoleWindow();
                    EventsByOrganizer.showByOrganizer();
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