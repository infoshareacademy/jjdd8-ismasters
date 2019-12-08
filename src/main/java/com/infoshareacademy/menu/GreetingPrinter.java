package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printGreeting() {
        stdout.info("┌────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                    │\n");
        stdout.info("│      \u001b[32mWitaj w kalendarzu wydarzeń kulturalnych      \u001b[0m│\n");
        stdout.info("│                                                    │\n");
        stdout.info("│                (c) ISMasters 2019                  │\n");
        stdout.info("│                                                    │\n");
        stdout.info("└────────────────────────────────────────────────────┘\n");
        stdout.info("\n");
        stdout.info("\n");
    }
}
