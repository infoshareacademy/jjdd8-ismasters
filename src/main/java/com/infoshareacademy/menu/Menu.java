package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.infoshareacademy.repository.FilterRepository;

import java.util.Scanner;

public class Menu {

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void mainMenu() {
        FilterRepository filterRepository = new FilterRepository();
        int mainExitCode = 0;

        stdout.info("┌──────────────────────────────────────────┐\n");
        stdout.info("│                                          │\n");
        stdout.info("│ \u001b[32mWitaj w kalendarzu wydarzeń kulturalnych \u001b[0m│\n");
        stdout.info("│                                          │\n");
        stdout.info("│           (c) ISMasters 2019             │\n");
        stdout.info("│                                          │\n");
        stdout.info("└──────────────────────────────────────────┘\n");
        stdout.info("\n");
        stdout.info("\n");

        while (mainExitCode != 9) {

            stdout.info("┌──────────────────────────────────────────┐\n");
            stdout.info("│                                          │\n");
            stdout.info("│  \u001b[33m Wybierz pozycję z menu używając cyfr  \u001b[0m │\n");
            stdout.info("│           \u001b[33m  na klawiaturze    \u001b[0m           │\n");
            stdout.info("│                                          │\n");
            stdout.info("│   1. Pokaż wszystkie wydarzenia          │\n");
            stdout.info("│   2. Pokaż najbliższe wydarzenia         │\n");
            stdout.info("│   3. Pokaż wydarzenie wg organizatora    │\n");
            stdout.info("│                                          │\n");
            stdout.info("│  \u001b[36m 9. Zakończ                    \u001b[0m         │\n");
            stdout.info("│                                          │\n");
            stdout.info("└──────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę: \n");

            switch (GetChoice.getChoice()) {
                case 1:
                    stdout.info("        WYBRANO OPCJĘ 1       \n");
                    for (Event event : filterRepository.allEvents()) {
                        stdout.info(event.toString());
                        stdout.info("\n");
                    }
                    stdout.info("\n");
                    break;
                case 2:
                    stdout.info("        WYBRANO OPCJĘ 2       \n");
                    new ShowNearestEvents().showNearestEvents();
                    break;
                case 3:
                    //TODO metoda 3
                    stdout.info("        WYBRANO OPCJĘ 3       \n");
                    new ShowByOrganizer().showByOrganizer();
                    break;
                case 9:
                    //TODO metoda 3
                    stdout.info("\n");
                    stdout.info("┌──────────────────────────────────────────┐\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│       \u001b[35m       DO ZOBACZENIA!      \u001b[0m        │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("└──────────────────────────────────────────┘\n");
                    stdout.info("\n");
                    mainExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    //TODO metoda 1
                    stdout.info("\n");
                    stdout.info("┌──────────────────────────────────────────┐\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│        \u001b[31mPOD TYM NUMEREM NIC NIE MA! \u001b[0m      │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│               JESZCZE RAZ!               │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("└──────────────────────────────────────────┘\n");
                    stdout.info("\n");
            }
        }
    }
}
