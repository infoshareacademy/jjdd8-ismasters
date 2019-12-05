package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


    public static void mainMenu() {
        int mainExitCode = 0;

        stdout.info("┌──────────────────────────────────────────┐\n");
        stdout.info("│                                          │\n");
        stdout.info("│ \u001b[32mWitaj w kalendarzu wydarzeń kulturalnych \u001b[0m│\n");
        stdout.info("│                                          │\n");
        stdout.info("│           (c) ISMasters 2019             │\n");
        stdout.info("│                                          │\n");
        stdout.info("└──────────────────────────────────────────┘\n");
        stdout.info("\n");
        stdout.info("\n");

        while (mainExitCode != 9) {

            stdout.info("┌──────────────────────────────────────────┐\n");
            stdout.info("│                                          │\n");
            stdout.info("│  \u001b[33m Wybierz pozycję z menu używając cyfr  \u001b[0m │\n");
            stdout.info("│           \u001b[33m  na klawiaturze    \u001b[0m           │\n");
            stdout.info("│                                          │\n");
            stdout.info("│   1. Pokaż najbliższe wydarzenia         │\n");
            stdout.info("│   2. Pokaż wydarzenia wg organizatora    │\n");
            stdout.info("│   3. Znajdź wydarzenie wg daty           │\n");
            stdout.info("│                                          │\n");
            stdout.info("│  \u001b[36m 9. Zakończ                    \u001b[0m         │\n");
            stdout.info("│                                          │\n");
            stdout.info("└──────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę: \n");


            switch (GetChoice.getChoice()) {
                case 1:
                    stdout.info("Wybór menu 1\n");
                    new Submenu1().doSomething();
                    break;
                case 2:
                    //TODO metoda2
                    stdout.info("Wybór menu 2\n");
                    new Submenu2().doSomething();
                    break;
                case 3:
                    //TODO metoda 3
                    stdout.info("Wybór menu 3\n");
                    break;
                case 9:
                    //TODO metoda 3
                    stdout.info("\n");
                    stdout.info("┌──────────────────────────────────────────┐\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│       \u001b[35m       DO ZOBACZENIA!      \u001b[0m        │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("└──────────────────────────────────────────┘\n");
                    stdout.info("\n");
                    mainExitCode = 9;
                    break;
                default:
                    //TODO metoda 1
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
    }

    public static void clearScreen() throws IOException {


        final String operatingSystem = System.getProperty("os.name");

        if (operatingSystem .contains("Windows")) {
            Runtime.getRuntime().exec("cls");
        }
        else {
            Runtime.getRuntime().exec("clear");
        }

//
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
    }
}
