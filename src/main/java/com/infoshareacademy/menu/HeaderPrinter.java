package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderPrinter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String ramka1 = "│                                                    │\n";
    private static final String ramka2 = "│                                                                  │\n";

    void printHeader() {
        stdout.info("┌────────────────────────────────────────────────────┐\n");
        stdout.info(ramka1);
        stdout.info("│       " + ColorHandler.YELLOW + "Wybierz pozycję z menu używając cyfr       " + ColorHandler.DEFAULT + "  │\n");
        stdout.info("│                " + ColorHandler.YELLOW + "  na klawiaturze    " + ColorHandler.DEFAULT + "                │\n");
        stdout.info(ramka1);
    }

    void printBiggerHeader() {
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n");
        stdout.info(ramka2);
        stdout.info("│       " + ColorHandler.YELLOW + "       Wybierz pozycję z menu używając cyfr               " + ColorHandler.DEFAULT + " │\n");
        stdout.info("│                " + ColorHandler.YELLOW + "        na klawiaturze    " + ColorHandler.DEFAULT + "                        │\n");
        stdout.info(ramka2);
        stdout.info(ramka2);
    }

}
