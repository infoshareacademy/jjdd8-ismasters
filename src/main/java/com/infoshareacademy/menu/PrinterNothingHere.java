package com.infoshareacademy.menu;

import com.infoshareacademy.menu.styleSettings.ColorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrinterNothingHere {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printNothingHere() {
        stdout.info("\n");
        stdout.info("┌──────────────────────────────────────────┐\n");
        stdout.info("│                                          │\n");
        stdout.info("│        " + ColorHandler.red + "POD TYM NUMEREM NIC NIE MA! " + ColorHandler.reset + "      │\n");
        stdout.info("│                                          │\n");
        stdout.info("│               JESZCZE RAZ!               │\n");
        stdout.info("│                                          │\n");
        stdout.info("└──────────────────────────────────────────┘\n");
        stdout.info("\n");
    }
}
