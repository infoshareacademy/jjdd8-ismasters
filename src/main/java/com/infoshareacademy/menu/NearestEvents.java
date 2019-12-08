package com.infoshareacademy.menu;

import com.infoshareacademy.menu.additionStyleClasses.ColorHandler;
import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static com.infoshareacademy.menu.PrinterEvents.printEvents;

public class NearestEvents {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void showNearestEvents() {
        FilterRepository filterRepository = new FilterRepository();

        int submenu2ExitCode = 0;

        while (submenu2ExitCode != 9) {
            stdout.info("\n");
            new HeaderPrinter().printHeader();
            stdout.info("│                                                    │\n");
            stdout.info("│   1. Pokaż dzisiejsze wydarzenia                   │\n");
            stdout.info("│   2. Pokaż jutrzejsze wydarzenia                   │\n");
            stdout.info("│   3. Pokaż wydarzenia za 3 dni                     │\n");
            stdout.info("│                                                    │\n");
            stdout.info("│  " + ColorHandler.cyan + " 9. Wróć                       " + ColorHandler.reset + "                   │\n");
            stdout.info("│                                                    │\n");
            stdout.info("└────────────────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę: \n");

            switch (GetChoice.getChoice()) {
                case 1:

                    printEvents(filterRepository.filterAllDatesEvents(LocalDate.now().toString()));
                    stdout.info("\n");
                    break;
                case 2:

                    printEvents(filterRepository.filterAllDatesEvents(LocalDate.now().plusDays(1).toString()));
                    stdout.info("\n");
                    break;
                case 3:

                    printEvents(filterRepository.filterAllDatesEvents(LocalDate.now().plusDays(2).toString()));
                    stdout.info("\n");
                    break;
                case 9:
                    stdout.info("        POWRÓT DO POPRZEDNIEGO MENU       \n");
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
