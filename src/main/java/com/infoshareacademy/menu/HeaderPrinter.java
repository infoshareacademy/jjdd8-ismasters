package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderPrinter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printHeader() {
        stdout.info("┌────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                    │\n");
        stdout.info("│       " + ColorHandler.YELLOW + "Wybierz pozycję z menu używając cyfr       " + ColorHandler.DEFAULT + "  │\n");
        stdout.info("│                " + ColorHandler.YELLOW + "  na klawiaturze    " + ColorHandler.DEFAULT + "                │\n");
        stdout.info("│                                                    │\n");
    }

    void printBiggerHeader() {
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                                  │\n");
        stdout.info("│       " + ColorHandler.YELLOW + "       Wybierz pozycję z menu używając cyfr               " + ColorHandler.DEFAULT + " │\n");
        stdout.info("│                " + ColorHandler.YELLOW + "        na klawiaturze    " + ColorHandler.DEFAULT + "                        │\n");
        stdout.info("│                                                                  │\n");
        stdout.info("│                                                                  │\n");
    }

}
