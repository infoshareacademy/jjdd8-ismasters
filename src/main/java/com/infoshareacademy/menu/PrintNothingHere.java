package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintNothingHere {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printNothingHere() {
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
