package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

import static com.infoshareacademy.menu.Menu.scanner;

public class ChoiceGetter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int getChoice() {
        int result = 0;

        try {
            String in = scanner.next();

            result = regexInputCheck(result, in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int regexInputCheck(int result, String in) {
        if ((Pattern.matches("[0-9]", in))) {
            result = regexTry(result, in);
        } else {
            stdout.info("\n");
            stdout.info(MenuBuilder.WRONG_INPUT_TOP);
            stdout.info(MenuBuilder.WRONG_INPUT_FRAME);
            stdout.info("│       " + ColorHandler.RED + "PODANO NIEPRAWIDŁOWĄ WARTOŚĆ! " + ColorHandler.DEFAULT + "     │\n");
            stdout.info(MenuBuilder.WRONG_INPUT_FRAME);
            stdout.info("│               JESZCZE RAZ!               │\n");
            stdout.info(MenuBuilder.WRONG_INPUT_FRAME);
            stdout.info(MenuBuilder.WRONG_INPUT_BOTTOM);
            stdout.info("\n");
        }
        return result;
    }

    private static int regexTry(int result, String in) {
        try {
            result = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            stdout.info("Zły format!" + e.getMessage());
        }
        return result;
    }
}