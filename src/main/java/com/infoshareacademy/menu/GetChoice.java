package com.infoshareacademy.menu;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.infoshareacademy.menu.Menu.clearScreen;
import static com.infoshareacademy.menu.Menu.scanner;

public class GetChoice {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int getChoice() {
        int result = 500;

        try {
            clearScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String in = scanner.next();
            if (StringUtils.containsOnly(in, "0123456789") && (Integer.parseInt(in) <= 9)) {
                try {
                    result = Integer.parseInt(in);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                stdout.info("\n");
                stdout.info("┌──────────────────────────────────────────┐\n");
                stdout.info("│                                          │\n");
                stdout.info("│       PODANO NIEPRAWIDŁOWĄ WARTOŚĆ!      │\n");
                stdout.info("│                                          │\n");
                stdout.info("│               JESZCZE RAZ!               │\n");
                stdout.info("│                                          │\n");
                stdout.info("└──────────────────────────────────────────┘\n");
                stdout.info("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
