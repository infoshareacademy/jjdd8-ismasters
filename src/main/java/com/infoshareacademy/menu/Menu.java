package com.infoshareacademy.menu;

import com.infoshareacademy.menu.additionStyleClasses.ColorHandler;
import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.infoshareacademy.menu.EventsPrinter.printEvents;

public class Menu {

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void mainMenu() {
        FilterRepository filterRepository = new FilterRepository();

        int mainExitCode = 0;

        new GreetingPrinter().printGreeting();

        while (mainExitCode != 9) {
            new HeaderPrinter().printHeader();
            stdout.info("│   1. Pokaż wszystkie wydarzenia                    │\n");
            stdout.info("│   2. Pokaż najbliższe wydarzenia                   │\n");
            stdout.info("│   3. Pokaż wydarzenie promowanych organizatorów    │\n");
            stdout.info("│                                                    │\n");
            stdout.info("│  " + ColorHandler.cyan + " 9. Zakończ                    " + ColorHandler.reset + "                   │\n");
            stdout.info("│                                                    │\n");
            stdout.info("└────────────────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę: \n");

            switch (GetChoice.getChoice()) {
                case 1:
                    printEvents(filterRepository.allEvents());
                    stdout.info("\n");
                    break;
                case 2:
                    new NearestEvents().showNearestEvents();
                    break;
                case 3:
                    new EventsByOrganizer().showByOrganizer();
                    break;
                case 9:
                    stdout.info("\n");
                    stdout.info("┌────────────────────────────────────────────────────┐\n");
                    stdout.info("│                                                    │\n");
                    stdout.info("│       " + ColorHandler.purple + "            DO ZOBACZENIA!           " + ColorHandler.reset + "        │\n");
                    stdout.info("│                                                    │\n");
                    stdout.info("└────────────────────────────────────────────────────┘\n");
                    stdout.info("\n");
                    mainExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    new PrinterNothingHere().printNothingHere();
            }
        }
    }
}