package com.infoshareacademy.menu.util;

import java.util.regex.Pattern;

public class InputValidator {
    public static boolean checkSingleDigitRangeInput(String in) {
        return (Pattern.matches("[0-9]", in));
    }
}