package com.infoshareacademy.menu;

import com.infoshareacademy.menu.util.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshareacademy.menu.Menu.scanner;

class ChoiceGetter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int getChoice() {
        int result = -1;

        String in = scanner.next();
        if (InputValidator.checkSingleDigitRangeInput(in)) {
            result = Integer.parseInt(in);
        } else {
            MenuBuilder.printWrongInputPrompt();
        }
        return result;
    }

}