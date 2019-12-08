package com.infoshareacademy.menu;

import com.infoshareacademy.menu.additionStyleClasses.ColorHandler;
import com.infoshareacademy.menu.additionStyleClasses.ScreenCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderPrinter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printHeader() {
        ScreenCleaner.cleanConsole();
        stdout.info("┌────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                    │\n");
        stdout.info("│       " + ColorHandler.yellow + "Wybierz pozycję z menu używając cyfr       " + ColorHandler.reset + "  │\n");
        stdout.info("│                " + ColorHandler.yellow + "  na klawiaturze    " + ColorHandler.reset + "                │\n");
        stdout.info("│                                                    │\n");
    }

    void printBiggerHeader() {
        ScreenCleaner.cleanConsole();
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                                  │\n");
        stdout.info("│       " + ColorHandler.yellow + "       Wybierz pozycję z menu używając cyfr               " + ColorHandler.reset + " │\n");
        stdout.info("│                " + ColorHandler.yellow + "        na klawiaturze    " + ColorHandler.reset + "                        │\n");
        stdout.info("│                                                                  │\n");
        stdout.info("│                                                                  │\n");
    }

}
