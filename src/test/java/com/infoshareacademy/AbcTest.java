package com.infoshareacademy;

import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.service.parser.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbcTest {

    @Test
    @DisplayName("todo fix me")
    void shouldLoadEventsToRepository() {
        Parser parser = new Parser();
        parser.initialization("src/test/resources/JSON_test.json");
        Assertions.assertEquals(EventsRepository.getInstance().getEvents().size(), 1);
        Assertions.assertEquals(EventsRepository.getInstance().getEvents().get(0).getid(), 69403);
    }

}
