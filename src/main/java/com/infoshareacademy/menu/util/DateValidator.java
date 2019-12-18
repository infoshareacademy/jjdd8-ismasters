package com.infoshareacademy.menu.util;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class DateValidator {
    public boolean isDateValid(String searchString) {
        try {
            LocalDate.parse(searchString);
            return Pattern.matches("^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$", searchString);
        } catch (Exception e) {
            return false;
        }
    }
}
