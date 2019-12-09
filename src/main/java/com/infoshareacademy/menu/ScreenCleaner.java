package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class ScreenCleaner{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String CHECKER = System.getProperty("os.name").toLowerCase();

    public static void cleanConsole() {

        try {
            if (CHECKER.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
            } else {
                stdout.info("\033[H\033[2J");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}