package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NothingHerePrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String ramka = "│                                          │\n";

    void printNothingHere() {
        ScreenCleaner.cleanConsole();
        stdout.info("\n");
        stdout.info("┌──────────────────────────────────────────┐\n");
        stdout.info(ramka);
        stdout.info("│        " + ColorHandler.RED + "POD TYM NUMEREM NIC NIE MA! " + ColorHandler.DEFAULT + "      │\n");
        stdout.info(ramka);
        stdout.info("│               JESZCZE RAZ!               │\n");
        stdout.info(ramka);
        stdout.info("└──────────────────────────────────────────┘\n");
        stdout.info("\n");
    }
}