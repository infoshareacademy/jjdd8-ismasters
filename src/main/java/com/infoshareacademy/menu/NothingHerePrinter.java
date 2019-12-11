package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NothingHerePrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String BORDER = "│                                          │\n";

    void printNothingHere() {
        ScreenCleaner.cleanConsole();
        stdout.info("\n");
        stdout.info(MenuBuilder.WRONG_INPUT_TOP);
        stdout.info(MenuBuilder.WRONG_INPUT_FRAME);
        stdout.info("│        " + ColorHandler.RED + "POD TYM NUMEREM NIC NIE MA! " + ColorHandler.DEFAULT + "      │\n");
        stdout.info(MenuBuilder.WRONG_INPUT_FRAME);
        stdout.info("│               JESZCZE RAZ!               │\n");
        stdout.info(MenuBuilder.WRONG_INPUT_FRAME);
        stdout.info(MenuBuilder.WRONG_INPUT_BOTTOM);
        stdout.info("\n");
    }
}