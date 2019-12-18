package com.infoshareacademy.menu.util;

import java.util.regex.Pattern;

public class InputValidator {

    /**
     * Validate user input for menu navigation
     *
     * @param in string representation of menu item number
     * @return true if a single digit in range 0 - 9 given
     */
    public static boolean checkSingleDigitRangeInput(String in) {
        return (Pattern.matches("[0-9]", in));
    }
}