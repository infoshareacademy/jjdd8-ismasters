package com.infoshareacademy.menu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChoiceGetterTest {

    @Test
    void checkGetChoiceWhenInputInRange() { //mock non-mockable class :)
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(1, ChoiceGetter.getChoice());
    }
}