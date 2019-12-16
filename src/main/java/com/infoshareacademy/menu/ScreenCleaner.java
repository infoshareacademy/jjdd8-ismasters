package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class ScreenCleaner{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String USER_OS = System.getProperty("os.name").toLowerCase();

    public static void cleanConsoleWindow() {

        try {
            if (USER_OS.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
            } else {
                stdout.info("\033[H\033[2J");
            }
        } catch (IOException e) {
            stdout.info("OS nie rozpoznany \n" + e);
        }
    }
}