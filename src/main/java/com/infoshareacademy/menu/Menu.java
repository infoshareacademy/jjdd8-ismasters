package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.infoshareacademy.menu.EventsPrinter.printEvents;

public class Menu extends MenuBuilder{

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    static int length = 61;
    final static String MAIN_MENU_OPTION1 = "1. Pokaż wszystkie wydarzenia";
    final static String MAIN_MENU_OPTION2 = "2. Pokaż najbliższe wydarzenia";
    final static String MAIN_MENU_OPTION3 = "3. Pokaż wydarzenie promowanych organizatorów";
    protected final static String FIXED_MENU_OPTION1 = String.format("%1$"+ (length-MAIN_MENU_OPTION1.length())/2+"s", MAIN_MENU_OPTION1);
    protected final static String FIXED_MENU_OPTION2 = String.format("%1$"+length+"s", MAIN_MENU_OPTION2);
    protected final static String FIXED_MENU_OPTION3 = String.format("%1$"+length+"s", MAIN_MENU_OPTION3);

    public static void mainMenu() {
        FilterRepository filterRepository = new FilterRepository();

        int mainExitCode = 0;
        ScreenCleaner.cleanConsole();
        new GreetingPrinter().printGreeting();

        while (mainExitCode != 9) {
//            new HeaderPrinter().printHeader();
//            stdout.info("│   1. Pokaż wszystkie wydarzenia                    │\n");
//            stdout.info("│   2. Pokaż najbliższe wydarzenia                   │\n");
//            stdout.info("│   3. Pokaż wydarzenie promowanych organizatorów    │\n");
//            stdout.info(MenuBuilder.MENU_FRAME);
//            stdout.info("│  " + ColorHandler.CYAN + " 9. Zakończ                    " + ColorHandler.DEFAULT + "                   │\n");
//            stdout.info(MenuBuilder.MENU_FRAME);
//            stdout.info(MenuBuilder.MENU_BOTTOM_FRAME);
//            stdout.info("\n");
//            stdout.info("Wpisz liczbę: \n");
            MenuBuilder.menuBuild();

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
                    MenuBuilder.goodByeWindow();
//                    stdout.info("\n");
//                    stdout.info(MenuBuilder.MENU_TOP_FRAME);
//                    stdout.info(MenuBuilder.MENU_FRAME);
//                    stdout.info("│       " + ColorHandler.PURPLE + "            DO ZOBACZENIA!           " + ColorHandler.DEFAULT + "        │\n");
//                    stdout.info(MenuBuilder.MENU_FRAME);
//                    stdout.info(MenuBuilder.MENU_BOTTOM_FRAME);
//                    stdout.info("\n");
                    mainExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    new NothingHerePrinter().printNothingHere();
            }
        }
    }
}