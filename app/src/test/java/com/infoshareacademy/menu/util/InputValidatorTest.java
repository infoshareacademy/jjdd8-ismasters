package com.infoshareacademy.menu.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputValidatorTest {

    @Test
    void checkSingleDigitRangeInputInRange() {
        assertTrue(InputValidator.checkSingleDigitRangeInput("0"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("1"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("2"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("3"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("4"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("4"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("5"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("6"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("7"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("8"));
        assertTrue(InputValidator.checkSingleDigitRangeInput("9"));
    }


    @Test
    void checkSingleDigitRangeInputTestGivenLetter() {
        assertFalse(InputValidator.checkSingleDigitRangeInput("z"));
        assertFalse(InputValidator.checkSingleDigitRangeInput("zsd,fbas"));
        assertFalse(InputValidator.checkSingleDigitRangeInput(","));
        assertFalse(InputValidator.checkSingleDigitRangeInput("."));
        assertFalse(InputValidator.checkSingleDigitRangeInput(""));
    }

    @Test
    void checkSingleDigitRangeInputTestGivenOutOfRangeValue() {
        assertFalse(InputValidator.checkSingleDigitRangeInput("15"));
        assertFalse(InputValidator.checkSingleDigitRangeInput("-1"));
        assertFalse(InputValidator.checkSingleDigitRangeInput("-10"));
        assertFalse(InputValidator.checkSingleDigitRangeInput("0.0"));
    }

    @Test
    void checkFiveDigitRangeInputTrue() {
        assertTrue(InputValidator.checkFiveDigitRangeInput("12345"));
        assertTrue(InputValidator.checkFiveDigitRangeInput("99999"));
        assertTrue(InputValidator.checkFiveDigitRangeInput("10000"));
        assertTrue(InputValidator.checkFiveDigitRangeInput("00000"));
        assertTrue(InputValidator.checkFiveDigitRangeInput("00001"));
    }
    @Test
    void checkFiveDigitRangeInputFalse() {
        assertFalse(InputValidator.checkFiveDigitRangeInput("5"));
        assertFalse(InputValidator.checkFiveDigitRangeInput("500001"));
        assertFalse(InputValidator.checkFiveDigitRangeInput("0"));
        assertFalse(InputValidator.checkFiveDigitRangeInput("10"));
        assertFalse(InputValidator.checkFiveDigitRangeInput("1111111111"));
        assertFalse(InputValidator.checkFiveDigitRangeInput("-1"));

    }

}