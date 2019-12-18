package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.Stack;

import static com.infoshareacademy.menu.EventsPrinter.printingEvents;

public class Menu extends MenuBuilder{

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    final static String MAIN_MENU_OPTION1 = "1. Pokaż wszystkie wydarzenia";
    final static String MAIN_MENU_OPTION2 = "2. Pokaż najbliższe wydarzenia";
    final static String MAIN_MENU_OPTION3 = "3. Pokaż wydarzenie promowanych organizatorów";
    final static String MAIN_MENU_EXIT = "Wpisane 9 powoduje wyjscie z programu";

    public static void mainMenu() {
        //w planach dodanie dynamicznego dodawania ale pierw przepchniecie pull requesta
        MenuBuilder.displayedOption1 = MAIN_MENU_OPTION1;
        MenuBuilder.displayedOption2 = MAIN_MENU_OPTION2;
        MenuBuilder.displayedOption3 = MAIN_MENU_OPTION3;
        MenuBuilder.GoBack = MAIN_MENU_EXIT;
        FilterRepository filterRepository = new FilterRepository();
        PathDisplay.pathDisplay();

        int mainExitCode = 0;
        ScreenCleaner.cleaningConsoleWindow();
        MenuBuilder.greetPrinting();
        pathDisplay.push();
        System.out.println( pathDisplay );
        while (mainExitCode != 9) {
            MenuBuilder.menuBuilderPrinting();
            switch (ChoiceGetter.getChoice()) {
                case 1:
                    printingEvents(filterRepository.allEvents());
                    stdout.info("\n");
                    break;
                case 2:
                    pathDisplay.push("Main menu1");
                    System.out.println( pathDisplay );
                    ScreenCleaner.cleaningConsoleWindow();
                    new NearestEvents().showNearestEvents();
                    break;
                case 3:
                    pathDisplay.push("Main menu2");
                    System.out.println( pathDisplay );
                    ScreenCleaner.cleaningConsoleWindow();
                    new EventsByOrganizer().showByOrganizer();
                    break;
                case 9:
                    pathDisplay.pop();
                    System.out.println( pathDisplay );
                    MenuBuilder.goodByeWindowPrinting();
                    mainExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    MenuBuilder.nothingHereYetPromptPrinting();
            }
        }
    }
}