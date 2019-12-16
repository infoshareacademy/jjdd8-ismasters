package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.infoshareacademy.menu.EventsPrinter.printEvents;

public class Menu extends MenuBuilder{

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static String MAIN_MENU_OPTION1 = "1. Pokaż wszystkie wydarzenia";
    final static String MAIN_MENU_OPTION2 = "2. Pokaż najbliższe wydarzenia";
    final static String MAIN_MENU_OPTION3 = "3. Pokaż wydarzenie promowanych organizatorów";
    final static String MAIN_MENU_EXIT = "Wpisane 9 powoduje wyjscie z programu";

    public static void mainMenu() {
        //w planach dodanie dynamicznego dodawania ale pierw przepchaniecie pull requesta
        MenuBuilder.displayedOption1 = MAIN_MENU_OPTION1;
        MenuBuilder.displayedOption2 = MAIN_MENU_OPTION2;
        MenuBuilder.displayedOption3 = MAIN_MENU_OPTION3;
        MenuBuilder.GoBack = MAIN_MENU_EXIT;
        FilterRepository filterRepository = new FilterRepository();

        int mainExitCode = 0;
        ScreenCleaner.cleanConsole();
        MenuBuilder.greetingPrinter();

        while (mainExitCode != 9) {
            MenuBuilder.buildMenuPrinter();

            switch (ChoiceGetter.getChoice()) {
                case 1:
                    printEvents(filterRepository.allEvents());
                    stdout.info("\n");
                    break;
                case 2:
                    ScreenCleaner.cleanConsole();
                    new NearestEvents().showNearestEvents();
                    break;
                case 3:
                    ScreenCleaner.cleanConsole();
                    new EventsByOrganizer().showByOrganizer();
                    break;
                case 9:
                    MenuBuilder.goodByeWindowPrinter();
                    mainExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    MenuBuilder.nothingHereYetPromptPrinter();
            }
        }
    }
}