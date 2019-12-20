package com.infoshareacademy.domain.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FavoriteEventTest {

    @Test
    void shouldReturnIdWhenIntegerSet() {
        FavoriteEvent favoriteEvent = new FavoriteEvent();
        favoriteEvent.setId(10);
        assertEquals(10, favoriteEvent.getId());
    }

    @Test
    void shouldReturnZeroWhenNoIdSet() {
        FavoriteEvent favoriteEvent = new FavoriteEvent();
        assertEquals(0, favoriteEvent.getId());
    }
}