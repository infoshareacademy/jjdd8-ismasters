package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshareacademy.menu.PrinterEvents.printEvents;

public class EventsByOrganizer {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void showByOrganizer() {
        FilterRepository filterRepository = new FilterRepository();
        int submenu2ExitCode = 0;

        while (submenu2ExitCode != 9) {
            stdout.info("\n");
            new PrinterHeader().printBiggerHeader();
            stdout.info("│   1. Pokaż Gdański Archipelag Kultury                            │\n");
            stdout.info("│   2. Pokaż Wojewódzka i Miejska Biblioteka Publiczna w Gdańsku   │\n");
            stdout.info("│   3. Pokaż Miejski Teatr MINIATURA                               │\n");
            stdout.info("│                                                                  │\n");
            stdout.info("│  \u001b[36m 9. Wróć                                                    \u001b[0m    │\n");
            stdout.info("│                                                                  │\n");
            stdout.info("└──────────────────────────────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę: \n");

            switch (GetChoice.getChoice()) {
                case 1:
                    printEvents(filterRepository.filterAllOrganisers("Gdański Archipelag Kultury"));
                    stdout.info("\n");
                    break;
                case 2:
                    printEvents(filterRepository.filterAllOrganisers("Wojewódzka i Miejska Biblioteka Publiczna w Gdańsku"));
                    stdout.info("\n");
                    break;
                case 3:

                    printEvents(filterRepository.filterAllOrganisers("Miejski Teatr MINIATURA"));
                    stdout.info("\n");
                    break;
                case 9:
                    stdout.info("        POWRÓT DO WYŻSZEGO POZIOMU       \n\n");
                    submenu2ExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    new PrinterNothingHere().printNothingHere();
            }
        }
    }
}
