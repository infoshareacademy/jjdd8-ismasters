package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderPrinter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String BORDER = "│                                                    │\n";
    private static final String BORDER2 = "│                                                                  │\n";

    void printHeader() {
        stdout.info("┌────────────────────────────────────────────────────┐\n");
        stdout.info(BORDER);
        stdout.info("│       " + ColorHandler.YELLOW + "Wybierz pozycję z menu używając cyfr       " + ColorHandler.DEFAULT + "  │\n");
        stdout.info("│                " + ColorHandler.YELLOW + "  na klawiaturze    " + ColorHandler.DEFAULT + "                │\n");
        stdout.info(BORDER);
    }

    void printBiggerHeader() {
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n");
        stdout.info(BORDER2);
        stdout.info("│       " + ColorHandler.YELLOW + "       Wybierz pozycję z menu używając cyfr               " + ColorHandler.DEFAULT + " │\n");
        stdout.info("│                " + ColorHandler.YELLOW + "        na klawiaturze    " + ColorHandler.DEFAULT + "                        │\n");
        stdout.info(BORDER2);
        stdout.info(BORDER2);
    }

}