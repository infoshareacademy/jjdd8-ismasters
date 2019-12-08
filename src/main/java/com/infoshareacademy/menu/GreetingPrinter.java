package com.infoshareacademy.menu;

import com.infoshareacademy.menu.additionStyleClasses.ColorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printGreeting() {
        stdout.info("┌────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                    │\n");
        stdout.info("│      " + ColorHandler.yellow + "Witaj w kalendarzu wydarzeń kulturalnych      " + ColorHandler.reset + "│\n");
        stdout.info("│                                                    │\n");
        stdout.info("│                (c) ISMasters 2019                  │\n");
        stdout.info("│                                                    │\n");
        stdout.info("└────────────────────────────────────────────────────┘\n");
        stdout.info("\n");
        stdout.info("\n");
    }
}
