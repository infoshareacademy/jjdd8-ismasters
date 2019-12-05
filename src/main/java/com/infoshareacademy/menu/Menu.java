package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static final Scanner scanner = new Scanner(System.in);


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");


    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        stdout.info("Witaj w kalendarzu wydarzeń kulturalnych\n");
        stdout.info("Najbliższe nadchodzące wydarzenia:\n");
        stdout.info("?????????????????????????????????:\n");
        //TODO: POkaz najbliższe wydarzenia

        int mainExitCode = 0;

        while (mainExitCode != 9) {

            stdout.info("----------------------------------\n");
            stdout.info("Wybierz menu:\n");
            stdout.info("1. Pokaż najbliższe wydarzenia\n");
            stdout.info("2. Pokaż wydarzenia wg organizatora\n");
            stdout.info("3. Znajdź wydarzenie wg daty\n");
            stdout.info("\n");
            stdout.info("Wpisz liczbę\n");


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
                    stdout.info("DO WIDZENIA!!!\n");
                    mainExitCode = 9;
                    break;
                default:
                    //TODO metoda 1
                    stdout.info("ZŁY WYBÓR\n");
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
