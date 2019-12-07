package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PrintEvents {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void printEvents(List<Event> eventList) {
        for (Event event : eventList) {
            stdout.info(event.toString());
            stdout.info("\n");
        }
    }
}
