package com.infoshareacademy.menu;

import com.infoshareacademy.menu.additionClasses.ColorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NothingHerePrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printNothingHere() {
        stdout.info("\n");
        stdout.info("┌──────────────────────────────────────────┐\n");
        stdout.info("│                                          │\n");
        stdout.info("│        " + ColorHandler.RED + "POD TYM NUMEREM NIC NIE MA! " + ColorHandler.DEFAULT + "      │\n");
        stdout.info("│                                          │\n");
        stdout.info("│               JESZCZE RAZ!               │\n");
        stdout.info("│                                          │\n");
        stdout.info("└──────────────────────────────────────────┘\n");
        stdout.info("\n");
    }
}
