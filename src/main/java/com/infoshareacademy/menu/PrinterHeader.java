package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrinterHeader {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printHeader() {
        stdout.info("┌────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                    │\n");
        stdout.info("│       \u001b[33m Wybierz pozycję z menu używając cyfr       \u001b[0m │\n");
        stdout.info("│                \u001b[33m  na klawiaturze    \u001b[0m                │\n");
        stdout.info("│                                                    │\n");
    }

    void printBiggerHeader() {
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n");
        stdout.info("│                                                                  │\n");
        stdout.info("│       \u001b[33m       Wybierz pozycję z menu używając cyfr               \u001b[0m │\n");
        stdout.info("│                \u001b[33m        na klawiaturze    \u001b[0m                        │\n");
        stdout.info("│                                                                  │\n");
        stdout.info("│                                                                  │\n");
    }

}
