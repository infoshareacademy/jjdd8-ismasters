package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static com.infoshareacademy.menu.Menu.scanner;

public class ChoiceGetter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int getChoice() {
        int result = 0;

        try {
            String in = scanner.next();

            result = regexInputChecking(result, in);
        } catch (PatternSyntaxException e) {
            stdout.info("Wystąpił błąd :(" + e.getMessage());
        }
        return result;
    }

    private static int regexInputChecking(int result, String in) {
        if ((Pattern.matches("[0-9]", in))) {
            result = regexExceptionCatching(result, in);
        } else {
            MenuBuilder.printWrongInputPrompt();
        }
        return result;
    }

    private static int regexExceptionCatching(int result, String in) {
        try {
            result = Integer.parseInt(in);
        } catch (NumberFormatException e) {
            stdout.info("Zły format!" + e.getMessage());
        }
        return result;
    }
}