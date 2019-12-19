package com.infoshareacademy.menu.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateValidatorTest {

    @Test
    @DisplayName("Should return true when valid date given")
    void isDateValid() {
        DateValidator dateValidator = new DateValidator();
        assertTrue(dateValidator.isDateValid("2019-01-01"));
        assertTrue(dateValidator.isDateValid("2019-01-31"));
        assertTrue(dateValidator.isDateValid("2019-01-30"));
        assertTrue(dateValidator.isDateValid("2020-02-29"));
        assertTrue(dateValidator.isDateValid("2020-02-28"));
        assertTrue(dateValidator.isDateValid("2019-02-28"));
        assertTrue(dateValidator.isDateValid("2019-12-31"));
        assertTrue(dateValidator.isDateValid("2019-12-19"));


    }

    @Test
    @DisplayName("Should return false when invalid date given")
    void isDateInvalid() {
        DateValidator dateValidator = new DateValidator();
        assertFalse(dateValidator.isDateValid("2019-01-40"));
        assertFalse(dateValidator.isDateValid("2019-1-1"));
        assertFalse(dateValidator.isDateValid("2019"));
        assertFalse(dateValidator.isDateValid("01"));
        assertFalse(dateValidator.isDateValid("asdgfd"));

    }
}