package com.infoshareacademy.menu.util;

public class HourValidation {
    public boolean isHourValid(String searchString) {
        String datePattern = "^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$";
        return searchString.matches(datePattern);
    }
}
