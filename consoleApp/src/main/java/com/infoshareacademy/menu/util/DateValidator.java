package com.infoshareacademy.menu.util;

public class DateValidator {

    /**
     * Validate input date to yyyy-MM-DD format
     *
     * @param searchString String representation of a date input from user console
     * @return true if date is in valid format including proper days count for each month and leap years
     */

    public boolean isDateValid(String searchString) {
        String datePattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        return searchString.matches(datePattern);
    }
}


